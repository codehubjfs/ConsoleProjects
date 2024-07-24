package com.hallbookingmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hallbookingmanagement.beans.Hall;
import com.hallbookingmanagement.service.CustomerServices;

@Controller

public class HallController {
	
	@Autowired
	CustomerServices customerservices;
	
	@GetMapping("/viewHalls")
	public ModelAndView viewController() {
		ModelAndView model = new ModelAndView();
		List<Hall> listHalls = customerservices.showHall();
		model.addObject("hallList",listHalls);
		model.setViewName("hall1.0");
		return model;
	}
}
