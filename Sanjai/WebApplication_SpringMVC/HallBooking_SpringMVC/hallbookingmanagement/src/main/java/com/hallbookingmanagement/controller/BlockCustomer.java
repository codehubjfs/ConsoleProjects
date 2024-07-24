package com.hallbookingmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hallbookingmanagement.beans.Customer;
import com.hallbookingmanagement.service.AdminServices;

@Controller
public class BlockCustomer {

    @Autowired
    private AdminServices adminServices;
    
    
   @RequestMapping(value ="/changeCustomerStatus",method= RequestMethod.GET)
    public String changeCustomerStatus(@RequestParam("userId") int userId, @RequestParam("status") String status,RedirectAttributes redirectAttributes) {
        System.out.println("in customer changed");
        Customer customerExisted = adminServices.changeCustomerStatus(userId, status);
        if (customerExisted != null) {
        	 redirectAttributes.addFlashAttribute("customerStatusChanged", customerExisted.getName() + " status is changed to " + status);
        } else {
            System.out.println("Not Updated");
        }
        
        return "redirect:/customerManagement";
    }
}
