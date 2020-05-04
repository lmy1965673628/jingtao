package com.ly.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.ly.service.UserService;
import com.ly.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisCluster;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired(required = false)
    private JedisCluster jedisCluster;
    @RequestMapping("/check/{param}/{type}")
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
    /**
     * 实现用户信息查询
     * /user/query/" + _ticket
     */
    @RequestMapping("/query/{ticket}")
    public JSONPObject findUserByTicket(@PathVariable String ticket,String callback) {

        String userJSON = jedisCluster.get(ticket);
        JSONPObject jsonpObject = null;
        if(StringUtils.isEmpty(userJSON)) {
            jsonpObject = new JSONPObject(callback,SysResult.fail());
        }else {
            jsonpObject = new JSONPObject(callback,SysResult.success().setData(userJSON));
        }
        return jsonpObject;
    }

}
