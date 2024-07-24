package com.hallbookingmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hallbookingmanagement.beans.Booking;
import com.hallbookingmanagement.service.AdminServices;

@Controller
public class BookingManagementController {
	
	@Autowired
	AdminServices adminServices;
	
	@GetMapping("/showManagebooking")
	public ModelAndView showManageBooking(ModelAndView model) {
		List<Booking>listBooking = adminServices.listBooking();
		model.addObject("bookingList",listBooking);
		model.setViewName("Admin/bookingManagement");
		return model;
	}

}
