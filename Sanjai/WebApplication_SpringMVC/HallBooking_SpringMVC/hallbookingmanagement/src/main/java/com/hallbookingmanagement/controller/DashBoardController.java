package com.hallbookingmanagement.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hallbookingmanagement.service.AdminServices;


@Controller
public class DashBoardController {
	@Autowired
	AdminServices adminServices;
	
	@GetMapping("/dashBoard")
	public ModelAndView viewDashBoard(ModelAndView model) {
		HashMap<String,String> attributes = adminServices.viewDashboardDetail();
		model.addAllObjects(attributes);
		model.setViewName("Admin/dashBoard");
		return model;
	}
}
