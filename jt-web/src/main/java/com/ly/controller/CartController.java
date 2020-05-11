package com.ly.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.ly.pojo.Cart;
import com.ly.service.DubboCartService;
import com.ly.util.UserThreadLocal;
import com.ly.vo.SysResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		Long userId = UserThreadLocal.get().getId();
		List<Cart> cartList = cartService.findCartListByUserId(userId);
		Double totalPrice=0.0;
		if(CollectionUtils.isNotEmpty(cartList)){
			totalPrice= cartList.stream().collect(Collectors.summingDouble(Cart::getItemPrice));
		}
		model.addAttribute("totalPrice",totalPrice);
		model.addAttribute("cartList", cartList);
		return "/cart";
	}
	/**
	 * 2.修改购物车商品数量
	 * 规则:如果{参数}的名称与对象中的属性一致.
	 * 		则可以使用对象直接取值.
	 */
	@PostMapping("/update/num/{itemId}/{num}")
	@ResponseBody
	public SysResult updateNum(@PathVariable Long itemId,@PathVariable Integer num) {
		Long userId = UserThreadLocal.get().getId();
		Cart cart = new Cart();
		cart.setUserId(userId).setItemId(itemId).setNum(num);
		cartService.updateNum(cart);
		return SysResult.success();
	}
	@RequestMapping("/delete/{itemId}")
	public String deleteCart(Cart cart) {
		Long userId = UserThreadLocal.get().getId();
		cart.setUserId(userId);
		cartService.deleteCart(cart);
		return "redirect:/cart/show";
	}
	/**
	 * 完成购物车新增
	 */
	@RequestMapping("/add/{itemId}")
	public String saveCart(Cart cart) {
		Long userId = UserThreadLocal.get().getId();
		cart.setUserId(userId);
		cartService.insertCart(cart);
		return "redirect:/cart/show";
	}

}
