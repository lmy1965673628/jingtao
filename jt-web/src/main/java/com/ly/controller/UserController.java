package com.ly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 实现用户页面跳转
     * http://www.jt.com/user/register.html
     * http://www.jt.com/user/login.html
     */
    @RequestMapping("/register")
    public String login() {

        return "/register";
    }

}
