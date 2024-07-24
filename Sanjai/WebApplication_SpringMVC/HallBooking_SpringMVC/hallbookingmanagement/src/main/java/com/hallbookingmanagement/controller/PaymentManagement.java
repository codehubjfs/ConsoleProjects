package com.hallbookingmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hallbookingmanagement.beans.Payment;
import com.hallbookingmanagement.service.AdminServices;

@Controller
public class PaymentManagement {
	
	@Autowired
	AdminServices adminServices;
	
	@GetMapping("/paymentManagement")
	public ModelAndView viewPaymentManagement(ModelAndView model) {
		List<Payment> paymentList =  adminServices.viewPaymentList();
		model.addObject("paymentList",paymentList);
		System.out.println("Im in the paymentManagement Controller");
		model.setViewName("Admin/paymentManagement");
		return model;
	}

}
