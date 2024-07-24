package com.hallbookingmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hallbookingmanagement.beans.Payment;
import com.hallbookingmanagement.service.CustomerServices;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ViewMyBooking {
	@Autowired
	CustomerServices customerServices;

	@GetMapping("/viewBooking")
	public ModelAndView viewBookings(ModelAndView model,HttpServletRequest request) {
		
		
		if(request.getSession().getAttribute("customer")==null) {
			model.setViewName("redirect:/viewLogin");
			return model;
		}
		
		
		List<Payment> userPaymentList = customerServices.showPaymentDetails(request);
		System.out.println(userPaymentList);
		model.addObject("PaymentList",userPaymentList);
		model.setViewName("MyBooking");
		return model;
	}
}
