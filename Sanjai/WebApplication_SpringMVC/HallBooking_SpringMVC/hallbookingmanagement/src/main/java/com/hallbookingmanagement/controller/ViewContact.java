package com.hallbookingmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hallbookingmanagement.beans.WebContactDetails;
import com.hallbookingmanagement.mapper.WebContactDetailMapper;
import com.hallbookingmanagement.service.AdminServices;

@Controller
public class ViewContact {
	
	@Autowired
	AdminServices adminServices;

	@GetMapping("/contact")
	public ModelAndView viewContact(ModelAndView model) {
		WebContactDetails webDetails = adminServices.getWebDetails();
		model.addObject("detail",webDetails);
		model.setViewName("contact");
		return model;
	}
}
