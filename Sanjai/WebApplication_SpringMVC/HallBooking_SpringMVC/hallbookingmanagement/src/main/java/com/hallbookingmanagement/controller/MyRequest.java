package com.hallbookingmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hallbookingmanagement.beans.Booking;
import com.hallbookingmanagement.beans.Customer;
import com.hallbookingmanagement.service.CustomerServices;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyRequest {
	
	@Autowired
	CustomerServices customerservices;
	
	@Autowired
	Customer customer;
	
	@GetMapping("/RequestHall")
	public ModelAndView hallRequest(ModelAndView model, HttpServletRequest request) {
		
		if(request.getSession().getAttribute("customer")==null) {
			model.setViewName("redirect:/viewLogin");
			return model;
		}
		
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		System.out.print(customer);
		List<Booking> bookingList =  customerservices.getMyRequest(customer.getUserId(), request);
		System.out.println(bookingList);
		model.addObject("bookList",bookingList);
		model.setViewName("MyRequest");
		return model;
	}
}
