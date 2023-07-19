package com.korea.k2.product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public void insertProduct(ProductVO vo) {
		mybatis.insert("ProductDao.insertProduct", vo);
	}

	@Override
	public List<ProductVO> selectAllProduct(ProductVO vo) {
		return mybatis.selectList("ProductDao.selectAllProduct", vo);
	}

	@Override
	public ProductVO selectOneProduct(ProductVO vo) {
		return mybatis.selectOne("ProductDao.selectOneProduct", vo);
	}

	@Override
	public void deleteProduct(ProductVO vo) {
		mybatis.delete("ProductDao.deleteProduct", vo);
	}

	@Override
	public ProductVO selectImgProduct(ProductVO vo) {
		return mybatis.selectOne("ProductDao.selectImgProduct", vo);
	}

	@Override
	public void updateProduct(ProductVO vo) {
		mybatis.update("ProductDao.updateProduct", vo);
	}

}
