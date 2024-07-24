package com.hallbookingmanagement.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hallbookingmanagement.beans.Hall;
import com.hallbookingmanagement.service.AdminServices;

@Controller
public class EditHallController {
	
	@Autowired
	AdminServices adminServices;
	
	@PostMapping("/EditHall")
	public ModelAndView editHall(@RequestParam("hallId") int hallId, @RequestParam("hallName") String hallName, @RequestParam("capacity") int capacity, @RequestParam("price") double price, @RequestParam("location") String location,@RequestParam("locationLink") String locationLink, ModelAndView model,RedirectAttributes redirectAttributes ) 
	{
		Hall isUpdated =  adminServices.updateHall(hallId, hallName,capacity, price, location, locationLink);
		if(isUpdated!=null) {
			redirectAttributes.addFlashAttribute("update",hallName +" is updated successfully");
			System.out.print("Update hall success fully");
		}
		else {
			System.out.print("not Update hall success fully");
		}

		return new ModelAndView("redirect:/showHallManagement");
	}

}
