package com.korea.k2.cart;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.korea.k2.order.OrderJumunVO;
import com.korea.k2.order.OrderMoneyVO;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void insertCart(CartVO vo) {
		mybatis.insert("CartDao.insertCart", vo);
	}

	@Override
	public List<CartVO> selectAllCart(CartVO vo) {
		return mybatis.selectList("CartDao.selectAllCart", vo);
	}

	@Override
	public int selectCustnoCount(CartVO vo) {
		return mybatis.selectOne("CartDao.selectCustnoCount", vo);
	}

	@Override
	public void deleteOneCart(CartVO vo) {
		mybatis.delete("CartDao.deleteOneCart", vo);
	}

	@Override
	public void deleteAllCart(CartVO vo) {
		mybatis.delete("CartDao.deleteAllCart", vo);
	}

	@Override
	public void updateCart(CartVO vo) {
		mybatis.update("CartDao.updateCart", vo);
	}

	@Override
	public void insertOrderJumun(OrderJumunVO vo) {
		mybatis.insert("CartDao.insertOrderJumun", vo);
	}

	@Override
	public void insertOrderMoney(OrderMoneyVO vo) {
		mybatis.insert("CartDao.insertOrderMoney", vo);
	}

	@Override
	public int selectOrderG(OrderMoneyVO vo) {
		return mybatis.selectOne("CartDao.selectOrderG", vo);
	}

	@Override
	public List<OrderMoneyVO> selectOrderMoney(OrderMoneyVO vo) {
		return mybatis.selectList("CartDao.selectOrderMoney", vo);
	}

	@Override
	public List<OrderJumunVO> selectOrderEdit(OrderJumunVO vo) {
		return mybatis.selectList("CartDao.selectOrderEdit", vo);
	}

}
