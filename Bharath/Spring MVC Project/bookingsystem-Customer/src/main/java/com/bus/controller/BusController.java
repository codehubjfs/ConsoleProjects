package com.bus.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bus.model.Bus;
import com.bus.service.BusService;

import java.util.List;

	@Controller
	public class BusController {

	    @Autowired
	    private BusService busService;

	    @RequestMapping("/bus")
	    public String getBusList(Model model) {
	        List<Bus> busList = busService.getBusList();
	        
	        for (Bus bus : busList) {
	            System.out.println("Bus ID: " + bus.getBusid());
	            System.out.println("Bus Name: " + bus.getBusName());
	        }

	        model.addAttribute("busList", busList);
	        return "Customer/BusList"; 
	    }
	}