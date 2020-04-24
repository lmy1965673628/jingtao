package com.ly.service;


import com.ly.pojo.Item;
import com.ly.pojo.ItemDesc;

public interface ItemService {
	//查询商品
	Item findItemById(Long itemId);
	
	//查询商品详情
	ItemDesc findItemDescById(Long itemId);
	
}
