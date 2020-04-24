package com.ly.controller;

import com.ly.pojo.Item;
import com.ly.pojo.ItemDesc;
import com.ly.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/items")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	/**
	 * 实现商品详情展现.
	 */
	 @RequestMapping("/{itemId}") 
	 public String findItemById(@PathVariable Long itemId, ModelMap model) {
		 Item item = itemService.findItemById(itemId);
		 ItemDesc itemDesc = itemService.findItemDescById(itemId);
		 model.addAttribute("item", item);
		 model.addAttribute("itemDesc", itemDesc);
		 return "/item"; //跳转到商品展现页面
	 }
}	
