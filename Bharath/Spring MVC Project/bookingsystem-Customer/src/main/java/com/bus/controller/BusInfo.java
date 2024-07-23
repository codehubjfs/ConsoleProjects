package com.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bus.model.Payment;
import com.bus.service.BookingService;

@Controller
public class BusInfo {
    @Autowired
    BookingService bookingService;
    @RequestMapping("/paymentinfo")
    public String paymentShows(Model model) {
    	List<Payment> payment=bookingService.getAllpayment();
        model.addAttribute("payments", payment);
        return "redirect:/payment"; 
    }
    
    
}
