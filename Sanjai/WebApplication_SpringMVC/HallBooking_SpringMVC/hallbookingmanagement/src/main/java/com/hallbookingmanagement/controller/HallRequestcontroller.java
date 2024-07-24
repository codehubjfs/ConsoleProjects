package com.hallbookingmanagement.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hallbookingmanagement.beans.Hall;
import com.hallbookingmanagement.service.CustomerServices;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HallRequestcontroller {
	
	@Autowired
	Hall hall;
	
	@Autowired
	CustomerServices services;
	@RequestMapping(value="/RequestSelectHall", method = RequestMethod.GET)
	public String requestHall(@RequestParam("event") String event,
			@RequestParam("seat") String seat,
			@RequestParam("bookedDate") LocalDate date,
			@RequestParam("numberDay") int numberOfDays,
			HttpServletRequest request) {
			System.out.println(event +"   "+seat+"  "+date+"  "+numberOfDays);
			Hall hall = (Hall)request.getSession().getAttribute("hallDetail");
			boolean isRequested = services.requestHall(request,event,seat, date, numberOfDays);
			return "redirect:RequestHall";
	}
}
