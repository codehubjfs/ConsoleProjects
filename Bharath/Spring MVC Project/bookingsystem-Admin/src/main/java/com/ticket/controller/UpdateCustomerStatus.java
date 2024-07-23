package com.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ticket.service.CustomerService;

@Controller
public class UpdateCustomerStatus {


  @Autowired
  private CustomerService customerService;

  @RequestMapping("/updateCustomer")
  @ResponseBody
  public String updateCustomerStatus(@RequestParam("id") int id, @RequestParam("status") String status) {
      customerService.updateCustomerStatus(id, status);
      return "Status updated successfully";
 }
}
