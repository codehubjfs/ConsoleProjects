package com.hallbookingmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hallbookingmanagement.service.AdminServices;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminLoginController {
	
	
	@Autowired
	AdminServices admin;
	
	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpServletRequest request) {
		try {
			System.out.println("Inside the controller");
			boolean validUser = admin.validateAdmin(name, password,request);
			if (!validUser) {
				model.addAttribute("error", "Invalid username or password");
				return "Admin/adminlogin"; 
			}
			model.addAttribute("loginSuccess", true);
			return "Admin/adminlogin"; // Return to the same page to show the modal
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
