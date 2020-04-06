package com.ly.service;


import com.ly.pojo.Item;
import com.ly.vo.EasyUITable;

public interface ItemService {
	
	EasyUITable findItemByPage(Integer page, Integer rows);
	void saveItem(Item item);
	void updateItem(Item item);
	void upateStatus(Long[] ids, int status);
}
