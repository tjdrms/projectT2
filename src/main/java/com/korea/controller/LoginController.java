package com.korea.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.korea.k2.shop.MemberVO;
import com.korea.k2.shop.ShopServiceImpl;


@Controller
public class LoginController {
	
	@Autowired
	private ShopServiceImpl ss;
	
	@RequestMapping(value = "login.do")
	String login(MemberVO vo, Model model, HttpSession session) {
		MemberVO m = ss.login(vo);
		if (m==null || m.equals(null)) {
			return "/login/login.jsp";
		} else {
			if (BCrypt.checkpw(vo.getPassword(), m.getPassword())) {
				session.setAttribute("loginSession", m);
				return "selectAllProduct.do";
			} else {
				return "/login/login.jsp";
			}
		}
	}
	
	@RequestMapping(value = "logout.do")
	String logout(MemberVO vo, Model model, HttpSession session) {
		session.invalidate();
		return "/index.jsp";
	}
}
