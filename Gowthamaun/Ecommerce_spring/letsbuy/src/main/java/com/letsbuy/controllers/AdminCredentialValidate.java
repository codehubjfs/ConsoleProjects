package com.letsbuy.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.letsbuy.beans.Account;
import com.letsbuy.beans.Admin;
import com.letsbuy.beans.Customer;
import com.letsbuy.services.AdminService;
import com.letsbuy.services.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminCredentialValidate {
	@Autowired
	AdminService adminService;
	
	@Autowired
	Admin admin;
	
//	@Autowired
//	Customer customer;
	
	@PostMapping("/validateCredential")
	public ModelAndView validateCredential(HttpServletRequest request,HttpServletResponse response,@RequestParam("username") String userName,@RequestParam("password") String password) {
		System.out.println("I am inside vlidate");
//		String userName = request.getParameter("username");
//		String password = request.getParameter("password");
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("passaword : "+password);
		System.out.println("username : "+userName);
		admin.setPassword(password);
		admin.setUserName(userName);
		int adminId = adminService.validateLogin(admin);
		System.out.println("id: "+adminId);
		System.out.println(admin.getUserName());
		if(adminId>0) {
			admin.setAdminId(adminId);
			request.getSession().setAttribute("admin",admin);
			modelAndView.setViewName("redirect:/AdminDashBoardController");
		}else {
			modelAndView.addObject("msg", "Invalid username or password");
			modelAndView.setViewName("views/admin/index");
		}
		return modelAndView;
	}
	
	@GetMapping("AdminDashBoardController")
	public ModelAndView getDashBoardData(HttpSession session,ModelAndView modelAndView,HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		Admin admin = (Admin) session.getAttribute("admin");
		if(admin==null) {
			modelAndView.setViewName("views/admin/index");
		}else {
			long buyersCount = adminService.getAllCustomers().stream().filter(c->c.getAccount().getAccountStatus().equals("ACTIVE")).collect(Collectors.toList()).size();
			long sellerCount = adminService.getAllVendors().size();
			long ordersCount = adminService.countOfOrders();
			modelAndView.addObject("customercount", buyersCount);
			modelAndView.addObject("sellercount", sellerCount);
			modelAndView.addObject("ordercount", ordersCount);
			modelAndView.setViewName("views/admin/dashboard");
		}
		return modelAndView;
	}
	
	
	
	@GetMapping("AdminLogoutController")
	public ModelAndView adminLogout(HttpSession session,ModelAndView modelAndView,HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
        
		 if (session != null) {
	        	session.removeAttribute("admin");
	            session.invalidate(); // Invalidate session
	        }

	        // Set cache control headers to prevent caching
	        

	        modelAndView.setViewName("views/admin/index"); 
	        return modelAndView;
	}
	
//	@GetMapping("CustomerManagementController")
//	public ModelAndView getCustomerData(HttpSession session,ModelAndView modelAndView) {
//		Admin admin = (Admin) session.getAttribute("admin");
//		if(admin==null) {
//			modelAndView.setViewName("views/admin/index");
//		}else {
//			List<Customer> customers = adminService.getAllCustomers();
//			customers.forEach(System.out::println);
//			modelAndView.addObject("customer", customers);
//			modelAndView.setViewName("views/admin/customermanagement");
//		}
//		return modelAndView;
//	}
//	
//	@PostMapping("CustomerManagementDeleteController")
//	public ModelAndView deleteCustomer(HttpSession session,ModelAndView modelAndView,HttpServletRequest request) {
//		Admin admin = (Admin) session.getAttribute("admin");
//		if(admin==null) {
//			modelAndView.setViewName("views/admin/index");
//		}else {
//			int customerId = Integer.parseInt(request.getParameter("cId"));
//			customer.setCustomerId(customerId);
//			customer = adminService.getAllCustomers().stream().filter(c->c.getCustomerId()==customerId).findFirst().orElse(null);
//			adminService.deleteCustomer(customer);
//			modelAndView.setViewName("redirect:/CustomerManagementController");
//		}
//		return modelAndView;
//	}
//	
//	@GetMapping("CustomerManagementEditController")
//	public ModelAndView customerEdit(HttpSession session,ModelAndView modelAndView,HttpServletRequest request) {
//		Admin admin = (Admin) session.getAttribute("admin");
//		if(admin==null) {
//			modelAndView.setViewName("views/admin/index");
//		}else {
//			int customerId = Integer.parseInt(request.getParameter("cid"));
//			String status = request.getParameter("customer");
//			customer.setCustomerId(customerId);
//			customer = adminService.getAllCustomers().stream().filter(c->c.getCustomerId()==customerId).findFirst().orElse(null);
//			adminService.editCustomer(customer,status);
//			modelAndView.setViewName("redirect:/CustomerManagementController");
//		}
//		return modelAndView;
//	}
}
