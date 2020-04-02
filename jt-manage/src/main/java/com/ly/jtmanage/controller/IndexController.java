package com.ly.jtmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping(value = {"/index","/"})
    public String index(){
        return "/views/index";
    }

}
