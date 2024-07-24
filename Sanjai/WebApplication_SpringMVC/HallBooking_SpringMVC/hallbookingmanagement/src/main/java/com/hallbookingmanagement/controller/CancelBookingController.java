package com.hallbookingmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hallbookingmanagement.service.CustomerServices;

@Controller
public class CancelBookingController {

	@Autowired
	CustomerServices customerServices;
	
	@GetMapping("/cancelRequest")
	public String cancelRequest(@RequestParam("bookingID") int bookingId ) {
		System.out.println("Cancel"+bookingId);
		customerServices.cancelBooking(bookingId);
		return "forward:RequestHall";
	}
}
