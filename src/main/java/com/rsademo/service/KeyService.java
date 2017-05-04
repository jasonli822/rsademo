package com.rsademo.service;

import com.rsademo.entity.RSAPubKey;
import com.rsademo.request.EncryptedRequest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

/**
 * Created by lihu on 2017/5/3.
 */
public interface KeyService {

    RSAPubKey getKey() throws NoSuchAlgorithmException;

    /**
     * JSON based decrypt method
     */
    <T> Optional<T> decrypt(EncryptedRequest request, Class<T> clazz) throws Exception;
}
