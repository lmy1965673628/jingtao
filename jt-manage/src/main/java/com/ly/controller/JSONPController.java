package com.ly.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.ly.pojo.ItemCat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSONPController {


    @RequestMapping("/web/testJSONP")
    public JSONPObject jsonp(String callback) {
        ItemCat itemCat = new ItemCat();
        itemCat.setId(10086L);
        itemCat.setName("jsonp测试调用!!!!");
        return new JSONPObject(callback, itemCat);
    }

}
