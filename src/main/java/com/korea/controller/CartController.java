package com.korea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.korea.k2.cart.CartServiceImpl;
import com.korea.k2.cart.CartVO;
import com.korea.k2.order.OrderJumunVO;
import com.korea.k2.order.OrderMoneyVO;

@Controller
public class CartController {
	@Autowired
	private CartServiceImpl cs;
	
	@RequestMapping(value = "insertCart.do")
	String insertCart(CartVO vo) {
		cs.insertCart(vo);
		return "selectAllCart.do";
	}
	
	@RequestMapping(value = "deleteOneCart.do")
	String deleteOneCart(CartVO vo) {
		cs.deleteOneCart(vo);
		return "selectCustnoCount.do";
	}
	
	@RequestMapping(value = "updateCart.do")
	String updateCart(@RequestParam String[] cartId, 
					  @RequestParam String[] custno, 
					  @RequestParam String[] productId, 
					  @RequestParam String[] amount) throws Exception {
		for (int i = 0; i < cartId.length; i++) {
			CartVO vo = new CartVO(); 
			vo.setCartId(Integer.parseInt(cartId[i]));
			vo.setAmount(Integer.parseInt(amount[i]));
			cs.updateCart(vo);
		}
		return "redirect:selectCustnoCount.do?custno=" + custno[custno.length-1];
	}
	
	@RequestMapping(value = "deleteAllCart.do")
	String deleteAllCart(CartVO vo) {
		cs.deleteAllCart(vo);
		return "selectCustnoCount.do";
	}
	
	@RequestMapping(value = "selectAllCart.do")
	ModelAndView selectAllCart(CartVO vo, ModelAndView mav) {
		mav.addObject("cartLi", cs.selectAllCart(vo)); 
		mav.setViewName("/cart/cartList.jsp");
		return mav;
	}
	
	@RequestMapping(value = "selectOrderMoney.do")
	ModelAndView selectOrderMoney(OrderMoneyVO vo, ModelAndView mav) {
		mav.addObject("orderLi", cs.selectOrderMoney(vo)); 
		mav.setViewName("/order/orderList.jsp");
		return mav;
	}
	
	@RequestMapping(value = "selectOrderEdit.do")
	ModelAndView selectOrderEdit(OrderJumunVO vo, ModelAndView mav) {
		mav.addObject("orderEditLi", cs.selectOrderEdit(vo)); 
		mav.setViewName("/order/orderEdit.jsp");
		return mav;
	}
	
	@RequestMapping(value = "selectCustnoCount.do")
	String selectCustnoCount(CartVO vo, ModelAndView mav) {
		int cnt = cs.selectCustnoCount(vo);
		if (cnt==0) {
			return "/cart/cartNo.jsp";
		} else {
			return "selectAllCart.do";
		}
	}
	
	@RequestMapping(value = "orderCart.do")
	String orderCart(@RequestParam String[] cartId, 
					  @RequestParam String[] custno, 
					  @RequestParam String[] productId, 
					  @RequestParam String[] productName, 
					  @RequestParam String[] amount,
					  OrderMoneyVO ovo) throws Exception {
		
		ovo.setCustno2(Integer.parseInt(custno[0]));
		cs.insertOrderMoney(ovo);
		int orderG = cs.selectOrderG(ovo);
		
		for (int i = 0; i < cartId.length; i++) {
			OrderJumunVO vo = new OrderJumunVO(); 
			vo.setCartId(Integer.parseInt(cartId[i]));
			vo.setAmount(Integer.parseInt(amount[i]));
			vo.setCustno(Integer.parseInt(custno[i]));
			vo.setProductId(Integer.parseInt(productId[i]));
			vo.setProductName(productName[i]);
			vo.setOrderG(orderG);
			cs.insertOrderJumun(vo);
		}
		return "redirect:selectCustnoCount.do?custno=" + String.valueOf(custno[custno.length-1]);
	}
}
