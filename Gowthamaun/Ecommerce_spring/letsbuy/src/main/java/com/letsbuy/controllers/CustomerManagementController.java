package com.letsbuy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.letsbuy.beans.Admin;
import com.letsbuy.beans.Customer;
import com.letsbuy.services.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerManagementController {
	@Autowired
	AdminService adminService;
	
	@Autowired
	Admin admin;
	
	@Autowired
	Customer customer;
	
	@GetMapping("CustomerManagementController")
	public ModelAndView getCustomerData(HttpSession session,ModelAndView modelAndView,HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin==null) {
			modelAndView.setViewName("views/admin/index");
		}else {
			List<Customer> customers = adminService.getAllCustomers();
			customers.forEach(System.out::println);
			modelAndView.addObject("customer", customers);
			modelAndView.setViewName("views/admin/customermanagement");
		}
		return modelAndView;
	}
	
	@PostMapping("CustomerManagementDeleteController")
	public ModelAndView deleteCustomer(HttpSession session,ModelAndView modelAndView,HttpServletRequest request) {
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin==null) {
			modelAndView.setViewName("views/admin/index");
		}else {
			int customerId = Integer.parseInt(request.getParameter("cId"));
			customer.setCustomerId(customerId);
			customer = adminService.getAllCustomers().stream().filter(c->c.getCustomerId()==customerId).findFirst().orElse(null);
			adminService.deleteCustomer(customer);
			modelAndView.setViewName("redirect:/CustomerManagementController");
		}
		return modelAndView;
	}
	
	@GetMapping("CustomerManagementEditController")
	public ModelAndView customerEdit(HttpSession session,ModelAndView modelAndView,HttpServletRequest request) {
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin==null) {
			modelAndView.setViewName("views/admin/index");
		}else {
			int customerId = Integer.parseInt(request.getParameter("cid"));
			String status = request.getParameter("customer");
			customer.setCustomerId(customerId);
			customer = adminService.getAllCustomers().stream().filter(c->c.getCustomerId()==customerId).findFirst().orElse(null);
			adminService.editCustomer(customer,status);
			modelAndView.setViewName("redirect:/CustomerManagementController");
		}
		return modelAndView;
	}
}
