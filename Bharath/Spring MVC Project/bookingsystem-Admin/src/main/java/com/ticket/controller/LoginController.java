package com.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ticket.model.Admin;
import com.ticket.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	@RequestMapping("/loginnew")
	    public String loginAdmin(@RequestParam("email") String email, 
	                             @RequestParam("password") String password, 
	                             Model model) {
	        Admin admin = loginService.loginAsAdmin(email, password);
	        if (admin != null) {
	        	model.addAttribute("success", "valid username or password");
	            return "redirect:/card";
	        } else {
	            model.addAttribute("error", "Invalid username or password");
	            return "Admin/LoginIndex";
	        }
	    }	  
}
