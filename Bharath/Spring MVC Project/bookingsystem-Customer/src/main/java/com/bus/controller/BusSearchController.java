package com.bus.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bus.model.Bus;
import com.bus.model.Payment;
import com.bus.model.Routes;
import com.bus.service.BusService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BusSearchController {
	    @Autowired
	    private BusService busService;

	    @RequestMapping("/busSearch")
	    public String searchBuses(@RequestParam("source") String startlocation,
	                              @RequestParam("destination") String endlocation,
	                              @RequestParam("travelDate")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate travelDate,
	                              Model model,HttpServletRequest request) {
	    	System.out.println(startlocation+" "+endlocation+" "+travelDate);
	        List<Bus> buses = busService.searchBuses(startlocation, endlocation, travelDate);
	     
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
	        List<Bus> busList = new ArrayList<>();
	        for (Bus bus : buses) {
	            Bus busNew = new Bus();
	            busNew.setBusid(bus.getBusid());
	            busNew.setBusName(bus.getBusName());
	            busNew.setBusType(bus.getBusType());
	            busNew.setBusCapacity(bus.getBusCapacity());
	            busNew.setBusFare(bus.getBusFare());
	            
	           
	            Routes route = new Routes();
	            route.setIndex(bus.getRoute().getIndex());
	            route.setSource(bus.getRoute().getSource());
	            route.setDestination(bus.getRoute().getDestination());
	            busNew.setRoute(route);
	            
	           
	            busNew.setFormattedDepartureDate(bus.getDepartureTime().format(dateFormatter));
	            busNew.setFormattedDepartureTime(bus.getDepartureTime().format(timeFormatter));
	            busNew.setFormattedArrivalDate(bus.getArrivalTime().format(dateFormatter));
	            busNew.setFormattedArrivalTime(bus.getArrivalTime().format(timeFormatter));
	            
	            busList.add(busNew);
	            
	            System.out.println("Bus Id: "+busNew.getBusid());
	            System.out.println("Bus Name: " + busNew.getBusName());
	            System.out.println("Bus Type: " + busNew.getBusType());
	            System.out.println("Bus Capacity: " + busNew.getBusCapacity());
	            System.out.println("Bus Fare: " + busNew.getBusFare());
	            System.out.println("Route ID: " + busNew.getRoute().getIndex());
	            System.out.println("Start Location: " + busNew.getRoute().getSource());
	            System.out.println("End Location: " + busNew.getRoute().getDestination());
	            System.out.println("Formatted Departure Date: " + busNew.getFormattedDepartureDate());
	            System.out.println("Formatted Departure Time: " + busNew.getFormattedDepartureTime());
	            System.out.println("Formatted Arrival Date: " + busNew.getFormattedArrivalDate());
	            System.out.println("Formatted Arrival Time: " + busNew.getFormattedArrivalTime());
//	            
//	            Payment pay=new Payment();
//	            
//	            pay.setBus(busNew);
//	            System.out.println(pay.getBus().getBusid());
//	            System.out.println(pay.getBus().getBusName());
//	            System.out.println(pay.getBus().getBusType());
//	            
	          
	        }
	        
//	        request.setAttribute("buses", busNews);
	        request.getSession().setAttribute("buses", busList);
	        model.addAttribute("buses", busList);
	        model.addAttribute("source", startlocation);
	        model.addAttribute("destination", endlocation);
	        return "Customer/BusDetails"; 
	    }
}
