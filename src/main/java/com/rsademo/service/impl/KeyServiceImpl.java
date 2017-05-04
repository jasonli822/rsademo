package com.rsademo.service.impl;

import com.alibaba.fastjson.JSON;
import com.rsademo.entity.RSAPrivateKey;
import com.rsademo.entity.RSAPubKey;
import com.rsademo.request.EncryptedRequest;
import com.rsademo.service.KeyService;
import com.rsademo.utils.RSA;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lihu on 2017/5/3.
 */
@Service("keyService")
public class KeyServiceImpl implements KeyService {

    private ConcurrentHashMap<String, RSAPrivateKey> keyStore = new ConcurrentHashMap<>();

    @Override
    public RSAPubKey getKey() throws NoSuchAlgorithmException {
        RSAPrivateKey privateKey = RSA.keyRSA();
        keyStore.put(privateKey.getId(), privateKey);
        return privateKey.transformToPubKey();
    }

    @Override
    public <T> Optional<T> decrypt(EncryptedRequest request, Class<T> clazz) throws Exception {
        RSAPrivateKey key = keyStore.get(request.getKeyId());
        if (key != null) {
            PrivateKey privateKey = RSA.generateRSAPrivateKey(key);
            return Optional.ofNullable(JSON.parseObject(RSA.decrypt(privateKey, request.getSecretText()), clazz));
        }
        return Optional.empty();
    }
}
