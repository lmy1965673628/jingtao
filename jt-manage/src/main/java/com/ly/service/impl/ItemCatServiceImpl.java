package com.ly.service.impl;


import com.ly.mapper.ItemCatMapper;
import com.ly.pojo.ItemCat;
import com.ly.service.ItemCatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Resource
	private ItemCatMapper itemCatMapper;
	@Override
	public String findItemCatNameById(Long itemCatId) {
		
		ItemCat itemCat = itemCatMapper.selectById(itemCatId);
		return itemCat.getName();
	}
}
