package com.hallbookingmanagement.controller;

import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hallbookingmanagement.beans.Booking;
import com.hallbookingmanagement.service.CustomerServices;

@Controller
public class FullPaymentController {
	
	@Autowired
	CustomerServices customerServices;
	
	@GetMapping("/fullPayment")
	public ModelAndView fullPayment(@RequestParam("paymentId") int paymentId, ModelAndView model) {
		System.out.println(paymentId);
		Booking  booking = customerServices.getPayment(paymentId);
		System.out.print(booking);
		model.addObject("booking", booking);
		long numberOfDays = ChronoUnit.DAYS.between(booking.getStartDate(), booking.getEndDate());
		long totalDays = numberOfDays * (long) booking.getHall().getPrice();
		model.addObject("totalPayment",totalDays);
		model.addObject("numberOfDays",numberOfDays);
		model.setViewName("PaymentPage");
		System.out.println("Payment Controller");
		model.setViewName("fullPayment");
		return model;
	}

}
