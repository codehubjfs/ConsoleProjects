package com.letsbuy.controllers;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.letsbuy.beans.Account;
import com.letsbuy.beans.Customer;
import com.letsbuy.beans.Login;
import com.letsbuy.beans.Product;
import com.letsbuy.services.CustomerService;
import com.letsbuy.services.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerLoginController {
	@Autowired
	Login login;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	Customer customer;
	
	@Autowired
	Account account;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/customerLogin")
	public ModelAndView navigateCustomerLogin(ModelAndView modelAndView,HttpServletResponse response,HttpServletRequest request) {
//		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("views/customer/login");
		return modelAndView;
		
	}
	
	@GetMapping("/forwardHomepage")
	public ModelAndView navigateHomePage(ModelAndView modelAndView,HttpServletResponse response,HttpServletRequest request) {
//		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("views/customer/home");
		return modelAndView;
	}
	
	@GetMapping("/forwardLogin")
	public ModelAndView navigateLoginPage(ModelAndView modelAndView,HttpServletResponse response,HttpServletRequest request) {
//		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("views/customer/login");
		return modelAndView;
	}
	
	@GetMapping("/customerRegister")
	public ModelAndView navigateCustomerRegister(ModelAndView modelAndView,HttpServletResponse response,HttpServletRequest request) {
//		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("views/customer/register");
		return modelAndView;
		
	}
	
	@GetMapping("CustomerLogoutController")
	public ModelAndView customerLogout(HttpSession session,ModelAndView modelAndView,HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		Customer customer = (Customer) session.getAttribute("user");
		if(customer!=null) {
			session.setAttribute("user", null);
			session.invalidate();
		}
		modelAndView.setViewName("views/customer/home");
		return modelAndView;
		
	}
	
	@PostMapping("/customerValidate")
	public ModelAndView validateCustomer(ModelAndView modelAndView,HttpServletResponse response,HttpServletRequest request,@RequestParam("mobile_no") long mobileNumber,@RequestParam("password") String password) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
//		ModelAndView modelAndView = new ModelAndView();
		System.out.println("Inside customer validate");
		login.setMobileNumber(mobileNumber);
		login.setPassword(password);
		Customer customer = customerService.validateCredentail(login);
		if(customer==null) {
			modelAndView.setViewName("views/customer/login");
			modelAndView.addObject("statusmessage", "Invalid Username or Password");
		}else {
			if(customer.getAccount().getAccountStatus().equals("DELETED")) {
				modelAndView.addObject("statusmessage", "Account Deleted");
				modelAndView.setViewName("views/customer/login");
			}else if(customer.getAccount().getAccountStatus().equals("BLOCKED")) {
				modelAndView.addObject("statusmessage", "Account Blocked");
				modelAndView.setViewName("views/customer/login");
			}else {
				customer = customerService.getCartDetails(customer);
				request.getSession().setAttribute("user", customer);
				modelAndView.setViewName("views/customer/home");
			}
		}
		
		return modelAndView;
	}
	
	
	
	/*
	 * 
	 * long MobileNumber = Long.parseLong(request.getParameter("mobile_no").trim());
		String emailId = request.getParameter("emailid").trim();
		String firstName = request.getParameter("first_name").trim();
		String lastName = request.getParameter("last_name").trim();
		String address = request.getParameter("address").trim();
		String gender = request.getParameter("gender");
		String userName = request.getParameter("username").trim();
		String password = request.getParameter("password");
		String accountType = "CUSTOMER";
		String accountStatus = "ACTIVE";*/
	@PostMapping("/CustomerRegisterController")
	public ModelAndView registerCustomer(ModelAndView modelAndView,@RequestParam("mobile_no") String mobileNumber,@RequestParam("emailid") String emailId,@RequestParam("first_name") String firstName,@RequestParam("last_name") String lastName,@RequestParam("address") String address,@RequestParam("gender") String gender,@RequestParam("username") String userName,@RequestParam("password") String password) {
		System.out.println("Inside customer register");
		account.setAccountStatus("ACTIVE");
		account.setAccountType("CUSTOMER");
		account.setPassword(password);
		account.setUserName(userName.trim());
		customer.setAccount(account);
		customer.setAddress(address.trim());
		customer.setEmail(emailId.trim());
		customer.setFirstName(firstName.trim());
		customer.setLastName(lastName.trim());
		customer.setGender(gender);
		long mobileNumberr = Long.parseLong(mobileNumber.trim());
		customer.setMobileNumber(mobileNumberr);
		boolean status = customerService.registerCustomer(customer);
		System.out.println(status);
		System.out.println(customer.getCustomerId());
		if(status) {
			boolean cartStatus = customerService.regsiterCart(customer);
			System.out.println(cartStatus);
		}
		modelAndView.setViewName("views/customer/login");
		return modelAndView;
	}
	
	@GetMapping("CustomerCartController")
	public ModelAndView fetchCart(HttpServletRequest request,HttpServletResponse response,ModelAndView modelAndView,HttpSession session) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		Customer customer = (Customer)session.getAttribute("user");
		String msg = request.getParameter("cart-update-status");
		if(customer==null) {
			modelAndView.setViewName("views/customer/login");
		}else {
			System.out.println("Inside cart controller"+customer);
			System.out.println(customer.getMyCart().getCart_id());
			customer = customerService.updateCartDetails(customer);
//			customer = customerService.getCartDetails(customer);
			request.getSession().setAttribute("user", customer);
			modelAndView.setViewName("views/customer/cart");
			modelAndView.addObject("cart-update-status", msg);
		}
		return modelAndView;
	}
	
	@GetMapping("mobilePage")
	public ModelAndView navigateMobilePage(ModelAndView modelAndView,HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		Map<Integer,Product> productsMap = productService.getAllProduct();
		productsMap = productsMap.entrySet().stream().filter((e)->e.getValue().getSubCategory().getSubCategoryName().equalsIgnoreCase("Mobile phones")).collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
		productsMap.forEach((k,v)->System.out.println(k+" "+v));
		request.getSession().setAttribute("mobiles", productsMap);
		modelAndView.setViewName("views/customer/mobiles");
		modelAndView.addObject("mobiles", productsMap);
		return modelAndView;
	}
}
