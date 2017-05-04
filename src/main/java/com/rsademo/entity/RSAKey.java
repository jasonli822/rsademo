package com.rsademo.entity;

import java.io.Serializable;
import java.time.Duration;
import java.util.UUID;

/**
 * Created by lihu on 2017/5/3.
 */
public abstract class RSAKey implements Serializable {

    private static final long serialVersionUID = 5686110814570011909L;

    private String id = UUID.randomUUID().toString().replaceAll("-", "");

    private String encryptType = "RSA";

    private long timestamp = System.currentTimeMillis();

    private long ttl = Duration.ofMinutes(5).toMillis();

    public RSAKey() {
    }

    public RSAKey(String id, String encryptType, long timestamp, long ttl) {
        this.id = id;
        this.encryptType = encryptType;
        this.timestamp = timestamp;
        this.ttl = ttl;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEncryptType() {
        return encryptType;
    }

    public void setEncryptType(String encryptType) {
        this.encryptType = encryptType;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }
}
