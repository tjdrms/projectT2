package com.korea.k2.cart;

import java.util.List;

import com.korea.k2.order.OrderJumunVO;
import com.korea.k2.order.OrderMoneyVO;

public interface CartService {
	void insertCart(CartVO vo);
	void deleteOneCart(CartVO vo);
	void deleteAllCart(CartVO vo);
	void updateCart(CartVO vo);
	void insertOrderJumun(OrderJumunVO vo);
	void insertOrderMoney(OrderMoneyVO vo);
	int selectOrderG(OrderMoneyVO vo);
	List<OrderMoneyVO> selectOrderMoney(OrderMoneyVO vo);
	List<OrderJumunVO> selectOrderEdit(OrderJumunVO vo);
	List<CartVO> selectAllCart(CartVO vo);
	int selectCustnoCount(CartVO vo);
}
