package com.ly.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ly.mapper.UserMapper;
import com.ly.pojo.User;
import com.ly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean checkUser(String param, Integer type) {
        String column = (type == 1) ? "username" : (type == 2 ? "phone" : "email");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(column, param);
        User user = userMapper.selectOne(queryWrapper);
        return user == null ? false : true;
    }
}
