package com.taskManage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public ModelAndView getLoginPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		session.getAttribute("errorMessage");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login/login");
		return mv;
	}


}
