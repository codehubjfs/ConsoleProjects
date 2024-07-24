package com.hallbookingmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OtpVerifierContoller {
	
	@PostMapping("/verifyOtp")
	public ModelAndView verifyPassword(ModelAndView model) {
		System.out.println("Hi");
		model.setViewName("changePassword");
		return model;
	}

}
