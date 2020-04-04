package com.ly.controller;

import com.ly.service.ItemService;
import com.ly.vo.EasyUITable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



//@Controller
@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	/**
	 * 根据分页查询商品信息
	 * http://localhost:8091/item/query?page=1&rows=50
	 * 作业:
	 * 	 根据分页参数,实现商品列表展现
	 */
	@RequestMapping("/query")
	public EasyUITable findItemByPage(Integer page, Integer rows) {
		
		return itemService.findItemByPage(page,rows);
	}
}
