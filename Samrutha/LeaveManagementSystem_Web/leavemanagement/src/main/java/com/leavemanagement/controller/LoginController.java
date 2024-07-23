package com.leavemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.leavemanagement.model.Employee;
import com.leavemanagement.model.Login;
import com.leavemanagement.model.Role;
import com.leavemanagement.service.EmployeeService;
import com.leavemanagement.service.EmployeeServiceImpl;
import com.leavemanagement.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("userType") Role role, Model model, HttpSession session) {
		
		Login user =  loginService.getLogin(username);
		
		System.out.println(user.getPassword() + "- Password");
		System.out.println(user.getUsername() + "- username");
		System.out.println("user type =  " + user.getRole());
		
		ModelAndView mv = new ModelAndView();
		
		if (user != null && user.getPassword().equals(password) && user.getRole() == role) {
			
            session.setAttribute("username", username);

            if (role == Role.EMPLOYEE) {
                mv.setViewName("redirect:/employee/edashboard"); // Redirect to Employee dashboard
            } else if (role == Role.MANAGER) {
                mv.setViewName("redirect:/manager/mdashboard"); // Redirect to Manager calendar
            } else if (role == Role.ADMIN) {
                mv.setViewName("redirect:/admin/adashboard"); // Redirect to Manager calendar
            } else {
                mv.setViewName("index"); // Default redirect
            }
        } else {
            session.setAttribute("errorMessage", "Invalid username or password or userType");
            mv.setViewName("redirect:/home"); // Redirect to login page with error message
        }
		
		return mv;
	}
	
	
	@RequestMapping("/forgetpassword")
	public ModelAndView getforgetpassword(Model model, HttpSession session) {
		
//		Login user =  loginService.getLogin(username);
//		
//		System.out.println(user.getPassword() + "- Password");
//		System.out.println(user.getUsername() + "- username");
//		System.out.println("user type =  " + user.getRole());
//		
//		ModelAndView mv = new ModelAndView();
//		
//		if (user != null && user.getPassword().equals(password) && user.getRole() == role) {
//			
//            session.setAttribute("username", username);
//
//            if (role == Role.EMPLOYEE) {
//                mv.setViewName("redirect:/employee/edashboard"); // Redirect to Employee dashboard
//            } else if (role == Role.MANAGER) {
//                mv.setViewName("redirect:/manager/mdashboard"); // Redirect to Manager calendar
//            } else {
//                mv.setViewName("index"); // Default redirect
//            }
//        } else {
//            session.setAttribute("errorMessage", "Invalid username or password or userType");
//            mv.setViewName("redirect:/home"); // Redirect to login page with error message
//        }
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login/ForgotForm");
		
		return mv;
	}
}
