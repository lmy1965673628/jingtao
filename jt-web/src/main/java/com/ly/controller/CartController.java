package com.ly.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.ly.pojo.Cart;
import com.ly.service.DubboCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/cart")
public class CartController {

	@Reference(timeout=3000)
	private DubboCartService cartService;
	/**
	 * 1.根据用户信息获取购物车列表数据
	 */
	@RequestMapping("/show")
	public String show(Model model) {
		Long userId = 7L; //暂时写死
		List<Cart> cartList = cartService.findCartListByUserId(userId);
		if(CollectionUtils.isNotEmpty(cartList)){
			Double totalPrice = cartList.stream().collect(Collectors.summingDouble(Cart::getItemPrice));
			model.addAttribute("totalPrice",totalPrice);
		}
		model.addAttribute("cartList", cartList);
		return "/cart";
	}

}
