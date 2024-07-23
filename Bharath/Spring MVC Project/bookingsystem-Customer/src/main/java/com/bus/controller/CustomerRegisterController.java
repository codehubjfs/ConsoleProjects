package com.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bus.model.CustomersNew;
import com.bus.service.RegisterService;

@Controller
public class CustomerRegisterController {
	@Autowired
    private RegisterService customerService;
	@RequestMapping("/register")
	 public String registerCustomer(
	            @RequestParam("firstname") String firstname,
	            @RequestParam("lastname") String lastname,
	            @RequestParam("username") String username,
	            @RequestParam("email") String email,
	            @RequestParam("gender") String gender,
	            @RequestParam("password") String password,
	            @RequestParam("phone") String phone,
	            Model model) {
		System.out.println(firstname+" "+lastname+" "+username+" "+email+" "+gender+" "+password+" "+phone);
	        
		 customerService.registerCustomer(firstname, lastname, username, email, gender, password, phone);
	        model.addAttribute("successMessage", "Registration successful!");
	        return "redirect:/login";
	    }
//    @RequestMapping("/register")
//    public String registerCustomer(@ModelAttribute("customer") CustomersNew customer, Model model) {
//        // Check if email already exists
//        if (customerService.isEmailAlreadyInUse(customer.getEmail())) {
//            model.addAttribute("error", "Email already exists. Please choose another.");
//            return "register"; 
//        }
//        customerService.registerCustomer(customer);
//        return "redirect:/register"; 
//    }
	}
