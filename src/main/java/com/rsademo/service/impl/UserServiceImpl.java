package com.rsademo.service.impl;

import com.rsademo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lihu on 2017/5/3.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private Map<String, String> userMap = new HashMap<String, String>(){{
        put("admin","admin");
        put("lihu","123456");
    }};

    @Override
    public boolean isValidUser(String username, String password) {
        String pwd = userMap.get(username);
        return password != null && password.equals(pwd);
    }
}
