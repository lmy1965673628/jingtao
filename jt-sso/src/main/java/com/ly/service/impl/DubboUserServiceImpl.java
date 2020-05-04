package com.ly.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ly.mapper.UserMapper;
import com.ly.pojo.User;
import com.ly.service.DubboUserService;
import com.ly.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import redis.clients.jedis.JedisCluster;

import java.util.Date;
import java.util.UUID;

@Service(timeout = 3000) //将对象交给dubbo管理
public class DubboUserServiceImpl implements DubboUserService {

	@Autowired(required = false)
	private JedisCluster jedisCluster;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void insertUser(User user) {
		//密码加密  注意加密和登录算法必须相同
		String md5Pass = 
		DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(md5Pass)
			.setCreated(new Date())
			.setUpdated(user.getCreated());
		userMapper.insert(user);
	}

	@Override
	public String doLogin(User user) {
		String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		user.setPassword(md5Pass);
		QueryWrapper<User> queryWrapper = new QueryWrapper<User>(user);
		User userDB = userMapper.selectOne(queryWrapper);
		String key = null;
		if(userDB!=null) {
			//表示用户名密码正确    UUID
			key = DigestUtils.md5DigestAsHex(UUID.randomUUID().toString().getBytes());
			String userJSON = JsonUtil.toJSON(userDB);
			jedisCluster.setex(key,7*24*3600, userJSON);
		}
		return key;
	}
}
