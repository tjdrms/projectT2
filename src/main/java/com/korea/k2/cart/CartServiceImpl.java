package com.korea.k2.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korea.k2.order.OrderJumunVO;
import com.korea.k2.order.OrderMoneyVO;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDaoImpl dao;
	@Override
	public void insertCart(CartVO vo) {
		dao.insertCart(vo);
	}
	@Override
	public List<CartVO> selectAllCart(CartVO vo) {
		return dao.selectAllCart(vo);
	}
	@Override
	public int selectCustnoCount(CartVO vo) {
		return dao.selectCustnoCount(vo);
	}
	@Override
	public void deleteOneCart(CartVO vo) {
		dao.deleteOneCart(vo);
	}
	@Override
	public void deleteAllCart(CartVO vo) {
		dao.deleteAllCart(vo);
	}
	@Override
	public void updateCart(CartVO vo) {
		dao.updateCart(vo);
	}
	@Override
	public void insertOrderJumun(OrderJumunVO vo) {
		dao.insertOrderJumun(vo);
	}
	@Override
	public void insertOrderMoney(OrderMoneyVO vo) {
		dao.insertOrderMoney(vo);
	}
	@Override
	public int selectOrderG(OrderMoneyVO vo) {
		return dao.selectOrderG(vo);
	}
	@Override
	public List<OrderMoneyVO> selectOrderMoney(OrderMoneyVO vo) {
		return dao.selectOrderMoney(vo);
	}
	@Override
	public List<OrderJumunVO> selectOrderEdit(OrderJumunVO vo) {
		return dao.selectOrderEdit(vo);
	}

}
