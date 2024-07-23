package com.bus.controller;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.bus.model.Booking;
//import com.bus.model.CustomersNew;
//import com.bus.service.PaymentService;
//
//import jakarta.servlet.http.HttpServletRequest;
//@Controller
//public class PaymentController {
//    @Autowired
//    @Lazy
//    private PaymentService paymentService;
//    @RequestMapping("/pay")
//    public String searchBuses(
//    						  @RequestParam("upinumber") String upi,
//    						  @RequestParam("card") String paymentMethod,
//    						  @RequestParam("paymentStatus") String paymentstatus,
//                              Model model,HttpServletRequest request) {
//    						 
//    						  model.addAttribute("message", "paid");
//    						  
//    						  List<Booking> book=(List<Booking>) request.getSession().getAttribute("Listofbookings");
//    						  book.stream().map(Booking::getRoute).forEach(b->System.out.println(b));
//    						  System.out.println(book);
//    			   paymentService.payAmount(upi, paymentMethod,paymentstatus,book);
//    			    return "paymentStatus";	
//    	
//    }
//}

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bus.model.Booking;
import com.bus.model.CustomersNew;
import com.bus.service.PaymentService;

import jakarta.servlet.http.HttpServletRequest;
@Controller
public class PaymentController {
    @Autowired
    @Lazy
    private PaymentService paymentService;
    @RequestMapping("/pay")
    public String searchBuses(
    						  @RequestParam("upinumber") String upi,
    						  @RequestParam("card") String paymentMethod, 
    						  @RequestParam("paymentStatus") String paymentstatus,
                              Model model,HttpServletRequest request) {
    						  model.addAttribute("message", "paid");
    						  List<Booking> book=(List<Booking>) request.getSession().getAttribute("Listofbookings");
    						  book.stream().map(Booking::getRoute).forEach(b->System.out.println(b));
    						  System.out.println("Payment Controller");
    						  System.out.println(book);
    						  System.out.println("---------");
    			   paymentService.payAmount(upi, paymentMethod,paymentstatus,book);
    			    return "book";	
    	
    }
}

