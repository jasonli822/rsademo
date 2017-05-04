package com.rsademo.controller;

import com.rsademo.entity.RSAPubKey;
import com.rsademo.request.EncryptedRequest;
import com.rsademo.request.LoginUserInfo;
import com.rsademo.service.KeyService;
import com.rsademo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

/**
 * Created by lihu on 2017/5/3.
 */
@Controller
public class UserController {

    @Autowired private KeyService keyService;
    @Autowired private UserService userService;

    @RequestMapping("/")
    public String index(Model model) {
        return "login";
    }

    /**
     * 获取公钥相关信息
     */
    @RequestMapping(value = "getKey", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<RSAPubKey> getEncryptKey() throws NoSuchAlgorithmException {
        RSAPubKey key = keyService.getKey();
        return ResponseEntity.ok(key);
    }

    /**
     * 用户登录
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Boolean> login(@RequestBody EncryptedRequest request) throws Exception {
        Optional<LoginUserInfo> userInfo = keyService.decrypt(request, LoginUserInfo.class);
        if (userInfo.isPresent()) {
            LoginUserInfo user = userInfo.get();
            return ResponseEntity.ok(userService.isValidUser(user.getUsername(), user.getPassword()));
        }
        return ResponseEntity.badRequest().body(false);
    }
}