package com.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bus.model.Booking;
import com.bus.model.CustomersNew;
import com.bus.model.Payment;
import com.bus.model.Routes;
import com.bus.service.BookingService;
import com.bus.service.CustomerLoginService;
import com.bus.service.CustomerService;


import jakarta.servlet.http.HttpSession;
@Controller
public class CustomerLoginController {
    @Autowired
    private CustomerLoginService loginService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BookingService bookService; 

    @RequestMapping("/loginAsCustomer")
    public String loginAdmin(@RequestParam("email") String email, 
                             @RequestParam("password") String password, 
                             Model model, 
                             HttpSession session) {
        CustomersNew customerNew = loginService.loginAsAdmin(email, password);
        List<CustomersNew> customers = customerService.viewCustomer();
        List<Booking> book=bookService.bookingList();
//        List<Payment> payment=bookService.getAllpayment();
 
        if (customerNew != null) {
            session.setAttribute("customersNew", customerNew);
            System.out.println("login successfully");
            model.addAttribute("success", "Valid username or password");
            return "redirect:/home";
        } else {
        	System.out.println("Invalid email or password");
            model.addAttribute("error", "Invalid username or password");
            return "Customer/Login";
        }
    }

    @RequestMapping("/logout")
    public String logoutAdmin(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }
}