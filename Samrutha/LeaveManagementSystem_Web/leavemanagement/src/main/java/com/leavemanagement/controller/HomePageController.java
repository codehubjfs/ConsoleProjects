package com.leavemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomePageController {
	
	@RequestMapping("/home")
	public ModelAndView getLoginPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login/Login");
		return mv;
	}
}
