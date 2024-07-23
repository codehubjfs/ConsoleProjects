package com.letsbuy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AdminLoginPage {
	
	@GetMapping("/adminlogin")
	public ModelAndView navigateAdminLogin(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("This is the navigate Controller");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("views/admin/index");
		return modelAndView;
	}
}
