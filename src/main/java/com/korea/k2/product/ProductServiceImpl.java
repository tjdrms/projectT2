package com.korea.k2.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDaoImpl dao;

	@Override
	public void insertProduct(ProductVO vo) {
		dao.insertProduct(vo);
	}

	@Override
	public List<ProductVO> selectAllProduct(ProductVO vo) {
		return dao.selectAllProduct(vo);
	}

	@Override
	public ProductVO selectOneProduct(ProductVO vo) {
		return dao.selectOneProduct(vo);
	}

	@Override
	public void deleteProduct(ProductVO vo) {
		dao.deleteProduct(vo);
	}

	@Override
	public ProductVO selectImgProduct(ProductVO vo) {
		return dao.selectImgProduct(vo);
	}

	@Override
	public void updateProduct(ProductVO vo) {
		dao.updateProduct(vo);
	}

}
