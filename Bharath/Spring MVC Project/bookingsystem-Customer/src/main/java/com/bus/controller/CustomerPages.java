package com.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerPages {
	
	@RequestMapping("/home")
	public String showHomePage() {
		System.out.println("Home");
	    return "Customer/Home"; 
	}
	@RequestMapping("/about")
	public String showAboutPage() {
		System.out.println("About us");
	    return "Customer/About"; 
	}
	@RequestMapping("/book")
	public String showBookPage() {
		System.out.println("Book");
	    return "Customer/Book"; 
	}
	@RequestMapping("/contact")
	public String showContactPage() {
		System.out.println("contact");
		return "Customer/Contact"; 
	}
	@RequestMapping("/login")
	public String showloginPage() {
		System.out.println("login");
	    return "Customer/Login"; 
	}
	@RequestMapping("/registerCustomer")
	public String showRegisterPage(){
		System.out.println("Registration page");
		return "Customer/Register";
	}
	@RequestMapping("/payment")
	public String showPaymentPage(){
		System.out.println("Payment page");
		return "Customer/Payment";
	}
	@RequestMapping("/cancel")
	public String showCancelPage(){
		System.out.println("Cancel page");
		return "Customer/CancelTicket";
	}
	@RequestMapping("/view")
	public String showViewPage(){
		System.out.println("View Ticket page");
		return "Customer/ViewTicket";
	}
	}
