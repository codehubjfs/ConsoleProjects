package com.ticket.controller;

import com.ticket.model.Customer;
import com.ticket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ViewCustomerController {

    @Autowired
    private CustomerService customerService;
    
    @RequestMapping("/customers")
    public String viewCustomers(Model model) {
    	System.out.println("hello");
        List<Customer> customers = customerService.viewCustomer();
        model.addAttribute("customers", customers);
        return "Admin/Customer"; 
    }
}
