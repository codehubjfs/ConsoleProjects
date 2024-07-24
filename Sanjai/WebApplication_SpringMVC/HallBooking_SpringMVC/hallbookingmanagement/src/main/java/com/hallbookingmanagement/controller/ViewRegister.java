package com.hallbookingmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ViewRegister {
	
	@GetMapping("/viewRegister")
	public String viewRegister(HttpServletResponse response) {
	
		return "register";
	}
}
