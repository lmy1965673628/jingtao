package com.ly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    /*
     * @RequestMapping("/") public String index() {
     *
     * return "想要跳转的页面"; }
     */

    /**
     * 实现通用页面跳转
     * 页面分析:
     * 1./page/item-add
     * 2./page/item-list
     * 3./page/item-param-list
     * <p>
     * RESTFul风格实现通用页面跳转
     * 获取url中的数据当做参数.
     * 步骤:
     * 1.将需要获取的数据使用{}包裹
     * 2.参数与参数之间使用/分割
     * 3.利用@PathVariable注解可以动态获取url中参数
     * 一般名称必须一致.
     * 如果名称不一致需要使用value属性标识.
     *
     * @return
     */
    @RequestMapping("/page/{modelName}")
    public String itemAdd(@PathVariable String modelName) {
        return modelName;
    }

    @RequestMapping("/")
    public String index() {
        return "/index";
    }
    @RequestMapping("/{name}")
    public String test(@PathVariable String name) {
        return "/"+name;
    }
    /**
     * 用于看easyUIdemo
     *
     * @param modelName
     * @return
     */
    @RequestMapping("/easy-ui/{modelName}")
    public String easyUI(@PathVariable String modelName) {
        return "/easy-ui/" + modelName;
    }

    @RequestMapping("getMsg")
    @ResponseBody
    public String getMsg() {
        return "我是8091端口服务";
    }
}
