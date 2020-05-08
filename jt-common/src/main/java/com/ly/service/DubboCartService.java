package com.ly.service;

import com.ly.pojo.Cart;

import java.util.List;


public interface DubboCartService {

	List<Cart> findCartListByUserId(Long userId);

}
