package com.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bus.model.Booking;
import com.bus.model.CustomersNew;
import com.bus.service.BookingService;
import com.bus.service.CustomerService;

import java.util.List;

@Controller
public class ViewCustomerController {

    @Autowired
    private CustomerService customerLoginService;
    @Autowired
    private BookingService bookService;
    @RequestMapping("/customers")
    public String viewCustomers(Model model) {
    	System.out.println("hello");
        List<CustomersNew> customers = customerLoginService.viewCustomer();
        model.addAttribute("customers", customers);
        System.out.println("Booking List");
        List<Booking> book=bookService.bookingList();
        model.addAttribute("booking",book);
        return "Admin/Customer"; 
    }
}
