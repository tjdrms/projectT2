package com.korea.k2.product;

import java.util.List;

public interface ProductDao {
	void insertProduct(ProductVO vo);
	void deleteProduct(ProductVO vo);
	void updateProduct(ProductVO vo);
	ProductVO selectOneProduct(ProductVO vo);
	ProductVO selectImgProduct(ProductVO vo);
	List<ProductVO> selectAllProduct(ProductVO vo);
}
