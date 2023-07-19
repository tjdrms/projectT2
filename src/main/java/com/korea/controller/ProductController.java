package com.korea.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.korea.k2.product.ProductServiceImpl;
import com.korea.k2.product.ProductVO;

@Controller
public class ProductController {
	
	String path ="";
	String timeStr ="";
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ProductServiceImpl ps;
	
	@Autowired
	private ServletContext servletContext;
	
	@PostConstruct 
	public void init() {
		path = servletContext.getRealPath("/product/files/");
	}
	
	@RequestMapping(value = "insertProduct.do")
	String insertProduct(ProductVO vo) throws IllegalStateException, IOException {
		long time = System.currentTimeMillis();
		SimpleDateFormat daytime =new SimpleDateFormat("HHmmss");
		timeStr=daytime.format(time);
    	
    	System.out.println("path:"+path);
    	
       	String fileName ="";
		MultipartFile updateFile = vo.getProductImg();
		fileName=updateFile.getOriginalFilename();
		File f=new File(path+fileName);
		if( !updateFile.isEmpty()) {
			if (f.exists()) {
			  String onlyFileName = fileName.substring(0,fileName.lastIndexOf(".")); 
			  String extension = fileName.substring(fileName.lastIndexOf(".")); 
			  fileName=onlyFileName+"_"+timeStr+extension;
			}
			updateFile.transferTo(new File(path+fileName));		  
		} else {
			 fileName= "space.png";
		}		
		vo.setProductImgStr(fileName);
    	ps.insertProduct(vo);
		return "selectAllProduct.do";
	}
	
	@RequestMapping(value = "selectAllProduct.do")
	ModelAndView selectAllProduct(ProductVO vo, ModelAndView mav) {
		mav.addObject("productLi", ps.selectAllProduct(vo));
		mav.setViewName("/product/productList.jsp");
		return mav; 
	}
	
	@RequestMapping(value = "selectOneProduct.do")
	ModelAndView selectOneProduct(ProductVO vo, ModelAndView mav) {
		mav.addObject("productM", ps.selectOneProduct(vo));
		mav.setViewName("/product/productEdit.jsp");
		return mav; 
	}
	
	@RequestMapping(value="deleteProduct.do")
	String  deleteProduct(ProductVO vo) throws Exception {
		ProductVO m = ps.selectImgProduct(vo);
		System.out.println("deleteProduct:" + vo);
		
		File delFile = new File(path + m.getProductImgStr() );
		
		if (!m.getProductImgStr().equals("space.png")) {
			delFile.delete(); 
		}
		
		ps.deleteProduct(vo);
		
		return "selectAllProduct.do";	
	}
	
	@RequestMapping(value="updateProduct.do")
	String updateProduct(ProductVO vo) {
		
		return "selectAllProduct.do";
	}

}
