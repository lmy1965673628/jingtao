package com.ly.service;


import com.ly.vo.EasyUITable;

public interface ItemService {
	
	EasyUITable findItemByPage(Integer page, Integer rows);
	
}
