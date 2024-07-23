package com.letsbuy.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.letsbuy.services.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/*
 * The main use of the ResponseBody is that the returned object is serialized into a JSON.
 * */
@Controller
@ResponseBody
public class CustomerDataController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/CustomerMobileDataController")
	public List<String> getAllMobileNumber(HttpServletRequest request,HttpServletResponse response) { 
		List<String> mobileNumbers = customerService.getAllMobileNumbers();
		return mobileNumbers;
	}
	
	@GetMapping("/CustomerEmailDataController")
	public List<String> getAllMobileEmail(HttpServletRequest request,HttpServletResponse response) { 
		List<String> emailAddress = customerService.getAllEmail();
		return emailAddress;
	}
	
	@GetMapping("/CustomerUsernameDataController")
	public List<String> getAllUserNames(HttpServletRequest request,HttpServletResponse response) { 
		List<String> userNames = customerService.getAlluserName();
		return userNames;
	}
	
}
