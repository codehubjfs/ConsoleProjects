package com.hallbookingmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hallbookingmanagement.service.AdminServices;

@Controller
public class AddHallController {
	
	@Autowired
	AdminServices adminServices;

	@PostMapping("/add-hall")
	public  String addHall(@RequestParam("hallName") String name, @RequestParam("isAc") String isAc,
			@RequestParam("pricePerDay") double price, @RequestParam("floatingCapacity") int capacity, 
			@RequestParam("location") String location,@RequestParam("locationLink") String locationLink,
			@RequestParam("amenities") String [] amenities,@RequestParam("events") String [] events,
			@RequestParam("theater") int theater,@RequestParam("cluster")int cluster,@RequestParam("banquet") int banquet, 
			@RequestParam("uShaped") int uShaped,@RequestParam("hallowSquare") int hallowSquare,
			@RequestParam("cabaretStyle") int cabaretStyle, RedirectAttributes redirectAttributes ) {
			
		 adminServices.addHallAndProperties(name, isAc, price, 
				 capacity, location, locationLink, amenities, events,
				 theater, cluster, banquet, uShaped, hallowSquare, cabaretStyle
			    );
		 redirectAttributes.addFlashAttribute("addHall",name +" is added successfully");
		return "redirect:showHallManagement";
	}
	
}
