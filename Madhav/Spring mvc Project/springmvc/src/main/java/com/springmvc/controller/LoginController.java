package com.springmvc.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.Admin;
import com.springmvc.model.Login;
import com.springmvc.model.Warden;
import com.springmvc.service.AdminService;
import com.springmvc.service.LoginService;
import com.springmvc.service.WardenService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@GetMapping("/forwardHomepage")
	public ModelAndView navigateHomePage(HttpServletResponse response,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Home/Login");
		return modelAndView;
	}
	
	@Autowired 
	Login login;
	
	@Autowired
	 LoginService loginService;
	
	@Autowired
	 AdminService adminService;
	
	@Autowired
	Admin admin;
	
	@Autowired
	WardenService wardenService;
	
	@Autowired
	Warden warden;
	
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("email") String email,@RequestParam("password") String password,
			@RequestParam("role") String role,HttpServletRequest request) {
		
		System.out.println(email);
		 ModelAndView mv = new ModelAndView();
		 boolean hasError = false;
	        if (email == null || email.isEmpty()) {
	        	mv.addObject("emailError", "Please enter your email.");
	            	
	            hasError = true;
	            
	        }
	        if (password == null || password.isEmpty()) {
	        	mv.addObject("passwordError", "Please enter your password.");
	           
	            hasError = true;
	            
	        }

	        if (hasError) {
	        	
	            mv.setViewName("Home/Login"); // Assuming index.jsp is your login page
	            return mv;
	           
	        }
		 
	        
	        int checkRole=0;
	        if(role.equals("Student")) {
				checkRole=1;
			}
			else if(role.equals("Admin")) {
				checkRole=2;
			}
			else if(role.equals("Warden")){
				checkRole=3;
			}
	        
	        
	        
	        switch(checkRole) {
	        case 1:
				// Check if user is valid
	        	 boolean isValidUser=false;
				 login=loginService.getUser(email, password, role);
				 if(login!=null)
				 isValidUser=true;

				if (isValidUser) {
				    // Set a session attribute indicating the user is logged in
					 HttpSession session = request.getSession();
				     session.setAttribute("email", email);
					 
				     mv.setViewName("redirect:/student/studentdashboard");
				        break;
					
				} else {
					
					 mv.addObject("error", "Invalid email or password.");
				    mv.setViewName("Home/Login");

 
				}
				break;
				
	        case 2:
	        	 isValidUser=false;
	        	admin=adminService.getAdminUser(email,password);
	        	
	        	 if(admin!=null)
					 isValidUser=true;
	        	
	        	
	        	
	        	if(isValidUser) {
	        		HttpSession session = request.getSession();
				     session.setAttribute("email", email);
	        		 mv.setViewName("redirect:/Admin/admindashboard");
	                    break;
	        	}
	        	else {
					  
					 mv.addObject("error", "Invalid email or password.");
				    mv.setViewName("Home/Login");


				}
				break;
				
	        case 3:
	        	isValidUser=false;
	        	System.out.println(email);
	        	System.out.println(password);
	        	warden=wardenService.getWardenUser(email,password);
	        	
	        	if(warden!=null) {
	        		HttpSession session = request.getSession();
				     session.setAttribute("email", email);
				     mv.setViewName("redirect:/warden/wardendashboard");
	        		
	        	}
	        	else {
	        		 mv.addObject("error", "Invalid email or password.");
					    mv.setViewName("Home/Login");
	        	}
	        	break;
	        
	        }
	        
	        return mv;
		
		
		
		
	}
	

}
