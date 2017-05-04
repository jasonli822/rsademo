package com.rsademo.request;

import java.io.Serializable;

/**
 * Created by lihu on 2017/5/3.
 */
public class EncryptedRequest implements Serializable {
    private static final long serialVersionUID = 7341239407950545625L;

    private String keyId;

    private String secretText;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getSecretText() {
        return secretText;
    }

    public void setSecretText(String secretText) {
        this.secretText = secretText;
    }
}
