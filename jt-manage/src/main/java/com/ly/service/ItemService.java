package com.ly.service;


import com.ly.pojo.Item;
import com.ly.pojo.ItemDesc;
import com.ly.vo.EasyUITable;

public interface ItemService {
	
	EasyUITable findItemByPage(Integer page, Integer rows);
	void saveItem(Item item, ItemDesc itemDesc);
	void updateItem(Item item, ItemDesc itemDesc);
	void upateStatus(Long[] ids, int status);

	ItemDesc findItemDescById(Long itemId);

	void deleteItems(Long[] ids);
}
