package com.hallbookingmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewAdminLogin {
	
	@GetMapping("/viewAdminLogin")
	public String viewAdminLogin() {
		System.out.println("AdminLogin");
		
		return "Admin/adminlogin";
	}
}
