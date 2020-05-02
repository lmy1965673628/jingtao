package com.ly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "/index";
    }

    @RequestMapping("/JSONP")
    public String test() {
        return "/JSONP";
    }

    @RequestMapping("/{name}")
    public String upload(@PathVariable String name) {
        return "/" + name;
    }
}
