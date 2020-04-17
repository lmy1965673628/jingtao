package com.ly.controller;

import com.ly.anno.CacheFind;
import com.ly.service.ItemCatService;
import com.ly.vo.EasyUITree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item/cat")
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	
	/**
	 * 根据商品分类Id号  查询商品分类名称
	 * url:/item/cat/queryItemName"
	 * data:{itemCatId:val}  http:String
	 *
	 * SpringMVC参数说明:
	 * 		规定:用户传递的参数名称必须和接收参数名称一致
	 * 		1.dispathServlet
	 * 		String data = request.getParameter("itemCatId");
			Long aa = Long.parseLong(data);
	 */
	@RequestMapping("/queryItemName")
	//不执行视图解析器代码
	public String findItemCatNameById(Long itemCatId) {

		return itemCatService.findItemCatNameById(itemCatId);
	}

	/**
	 * @RequestParam
	 * 		defaultValue: 	当参数为null时 设定默认值
	 * 		name/value:     获取用户传递的数据信息
	 * 		required: 		是否为必须传递的数据
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/list")
	@CacheFind(seconds = 60)
	public List<EasyUITree> findItemCatList(@RequestParam(defaultValue="0",name ="id") Long parentId){
		//查询一级商品分类信息
		return itemCatService.findEasyUITreeList(parentId);
//		return itemCatService.findEasyUITreeCache(parentId);
	}
}
