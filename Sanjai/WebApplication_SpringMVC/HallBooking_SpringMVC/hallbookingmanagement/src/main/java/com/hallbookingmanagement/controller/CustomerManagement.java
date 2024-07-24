package com.hallbookingmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hallbookingmanagement.beans.Customer;
import com.hallbookingmanagement.service.AdminServices;

@Controller
public class CustomerManagement {
	@Autowired
	AdminServices admiServices;
	
	@GetMapping("/customerManagement")
	public ModelAndView showCustomerManagement(ModelAndView model) {
		List<Customer> customerList = admiServices.listCustomer();
		model.addObject("customerList",customerList);
		model.setViewName("Admin/customerManagement");
		return model;
	}

}
