package com.hallbookingmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hallbookingmanagement.service.CustomerServices;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ChangePasswordController {
	
	@Autowired
	CustomerServices customerServices;
	
	@PostMapping("changePassword")
	public ModelAndView changePassword(@RequestParam("password") String password, @RequestParam("mail") String mail, ModelAndView model, HttpServletRequest request) {
		customerServices.changePassword(mail, password,request);
		return model;
	}

}
