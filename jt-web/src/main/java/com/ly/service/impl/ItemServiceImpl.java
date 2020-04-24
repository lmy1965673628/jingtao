package com.ly.service.impl;

import com.ly.pojo.Item;
import com.ly.pojo.ItemDesc;
import com.ly.service.ItemService;
import com.ly.util.HttpClientService;
import com.ly.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private HttpClientService httpClient;
	//需要从后台获取商品信息

	@Override
	public Item findItemById(Long itemId) {
		String url = 
				"http://manage.jt.com/web/item/findItemById";
		Map<String,String> params = new HashMap<String, String>();
		params.put("itemId", ""+itemId);
		String result = httpClient.doGet(url, params);
		return JsonUtil.toObject(result, Item.class);
	}

	@Override
	public ItemDesc findItemDescById(Long itemId) {
		String url = 
				"http://manage.jt.com/web/item/findItemDescById";
		Map<String,String> params = new HashMap<String, String>();
		params.put("itemId", ""+itemId);
		String result = httpClient.doGet(url, params);
		return JsonUtil.toObject(result, ItemDesc.class);
	}
}
