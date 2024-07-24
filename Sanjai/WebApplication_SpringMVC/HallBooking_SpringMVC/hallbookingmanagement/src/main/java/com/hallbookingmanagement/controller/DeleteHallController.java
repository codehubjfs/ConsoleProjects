package com.hallbookingmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hallbookingmanagement.service.AdminServices;

@Controller
public class DeleteHallController {
	
	@Autowired
	AdminServices adminServices;
	
	@GetMapping("/deleteHall")
	public String deleteHall(@RequestParam("hallId") int hallId, ModelAndView model) {
		System.out.println("i'm in delete table");
		boolean isDelete = adminServices.deleteHall(hallId);
		if(isDelete) {
			System.out.println("deleted successfully");
			
		}
		return "redirect:showHallManagement";
		
	}

}
