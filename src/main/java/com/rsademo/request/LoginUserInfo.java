package com.rsademo.request;

import java.io.Serializable;

/**
 * Created by lihu on 2017/5/3.
 */
public class LoginUserInfo implements Serializable {
    private static final long serialVersionUID = 7046581186920883034L;

    private String username;

    private String password;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
