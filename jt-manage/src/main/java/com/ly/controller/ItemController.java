package com.ly.controller;

import com.ly.pojo.Item;
import com.ly.service.ItemService;
import com.ly.vo.EasyUITable;
import com.ly.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	/**
	 * 根据分页查询商品信息
	 * http://localhost:8091/item/query?page=1&rows=50
	 */
	@RequestMapping("/query")
	public EasyUITable findItemByPage(Integer page, Integer rows) {

		return itemService.findItemByPage(page,rows);
	}
	/**
	 * 实现商品数据新增
	 * 改进方法:定义全局异常处理机制
	 */
	@RequestMapping("/save")
	public SysResult saveItem(Item item) {
		itemService.saveItem(item);
		return SysResult.success();
	}
	/**
	 * 实现商品信息修改
	 */
	@RequestMapping("/update")
	public SysResult updateItem(Item item) {

		itemService.updateItem(item);
		return SysResult.success();
	}
	/**
	 * 实现商品的下架操作
	 * $.post("/item/instock",{"ids":1001,1002}
	 *
	 * 规则:
	 * 	如果用户传参使用","号分割参数,则springMVC
	 * 接收参数时可以使用数组接收.由程序内部实现自动
	 * 转化
	 * ids:1001,1002,1003
	 */
	@RequestMapping("/instock")
	public SysResult instock(Long[] ids) {
		int status = 2;	//表示下架
		itemService.upateStatus(ids,status);
		return SysResult.success();
	}

	@RequestMapping("/reshelf")
	public SysResult reshelf(Long[] ids) {
		int status = 1;	//表示上架
		itemService.upateStatus(ids,status);
		return SysResult.success();
	}

}
