package com.rsademo;

import com.rsademo.entity.RSAPrivateKey;
import com.rsademo.utils.RSA;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by lihu on 2017/5/3.
 */
public class RSATest {
    @Test
    public void testRSA() throws Exception {
        RSAPrivateKey keyPair = RSA.keyRSA();
        PublicKey publicKey = RSA.generateRSAPublicKey(keyPair.transformToPubKey());
        PrivateKey privateKey = RSA.generateRSAPrivateKey(keyPair);

        // test
        String rawStr = RandomStringUtils.randomAlphabetic(100);

        String secretText = RSA.encrypt(publicKey, rawStr);
        String result = RSA.decrypt(privateKey, secretText);

        assertThat(rawStr, is(result));

    }
}