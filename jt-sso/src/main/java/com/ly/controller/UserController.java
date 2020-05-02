package com.ly.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.ly.service.UserService;
import com.ly.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("user/check/{param}/{type}")
    public JSONPObject checkUser(@PathVariable String param, @PathVariable Integer type, String callback) {
        JSONPObject jsonpObject;
        try {
            boolean flag = userService.checkUser(param, type);
            jsonpObject = new JSONPObject(callback, SysResult.success(flag));
        } catch (Exception e) {
            e.printStackTrace();
            jsonpObject = new JSONPObject(callback, SysResult.fail());
        }
        return jsonpObject;
    }
}
