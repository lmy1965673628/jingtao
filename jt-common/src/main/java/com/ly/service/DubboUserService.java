package com.ly.service;


import com.ly.pojo.User;

public interface DubboUserService {

	void insertUser(User user);
	//实现数据库查询
	String doLogin(User user);
}