package com.hallbookingmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ViewLogin {

	@GetMapping("/viewLogin")
	public String requestMethodName(HttpServletResponse response) {
		System.out.println("View Login page is working");
		 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
	     response.setHeader("Pragma", "no-cache");
	     response.setDateHeader("Expires", 0);
		return "login";
	}
}
