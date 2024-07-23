package com.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ticket.model.RoutesBean;
import com.ticket.service.RouteService;
@Controller
public class NewRoute {
	
	    @Autowired
	    private RouteService routeService;
	
	    @RequestMapping("/addRoute")
	    public String addRoute(
	            @RequestParam("source") String startLocation,
	            @RequestParam("end") String endLocation,
	            @RequestParam("dis") int distance,
	            @RequestParam("time") int duration,
	            Model model) {
	    	 System.out.println("Start Location: " + startLocation);
	         System.out.println("End Location: " + endLocation);
	         System.out.println("Distance: " + distance);
	         System.out.println("Duration: " + duration);
	        
	        RoutesBean route = new RoutesBean();
	        route.setStartLocation(startLocation);
	        route.setEndLocation(endLocation);
	        route.setDistance(distance);
	        route.setEstimatedDuration(duration);
	        routeService.addRoute(route);
	        model.addAttribute("message", "Route added successfully!");
	        return "redirect:/viewroutes"; 
	    }
}