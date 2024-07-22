package com.taskManage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.taskManage.model.UserModel;
import com.taskManage.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("email") String email, 
            @RequestParam("password") String password,
            @RequestParam("usertype") String userType,HttpSession session) {
		
		
		UserModel user = userservice.findByEmail(email, password, userType);
		ModelAndView modelandview = new ModelAndView();
		
        if (user != null && user.getEmail().equals(email) && user.getPassword().equals(password)) {
            session.setAttribute("Email", email);
            
            switch (user.getRole()) {
                case "employee":
                    modelandview.setViewName("redirect:/employee/dashboard");
                    break;
                case "manager":
                    modelandview.setViewName("redirect:/manager/dashboard");
                    break;
                case "admin":
                    modelandview.setViewName("redirect:/admin/dashboard");
                    break;
                default:
                	session.setAttribute("errorMessage", "User not found.");
                    modelandview.setViewName("redirect:/home");
                    
                    break;
            }
        } else {
        	session.setAttribute("errorMessage", "Invalid email or password");
            modelandview.setViewName("redirect:/home");
            
        }
		return modelandview;
	
	}


}
