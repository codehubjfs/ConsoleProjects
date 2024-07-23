package com.leavemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.leavemanagement.model.Employee;
import com.leavemanagement.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@ResponseBody
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/adashboard")
	public ModelAndView getDashboard(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
        
		Employee emp = employeeService.getEmployeeDetail((String)session.getAttribute("username"));
        session.setAttribute("employee", emp);
        
    	
        if (emp== null) {
        	mv.setViewName("redirect:/home");
        	return mv;
            
        }
        else {
        	mv.setViewName("Admin/index");
        }
		
		
		return mv;
	}
	
	
	@RequestMapping("/aprofile")
	public ModelAndView getProfile(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		String username = (String)request.getSession().getAttribute("username");
		Employee emp = (Employee) request.getSession().getAttribute("employee");
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		
        ModelAndView mv = new ModelAndView();
        if (emp==null) {
        	mv.setViewName("redirect:/home");
            
        } 
        else{
	            mv.setViewName("Admin/Profile");
	        }
        return mv;
	}
	
	
	@RequestMapping("/employeeManagement")
	public ModelAndView getEmployeeManagement(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		String username = (String)request.getSession().getAttribute("username");
		Employee emp = (Employee) request.getSession().getAttribute("employee");
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		
        ModelAndView mv = new ModelAndView();
        if (emp==null) {
        	mv.setViewName("redirect:/home");
            
        } 
        else{
	            mv.setViewName("Admin/EmployeeManagement");
	        }
        return mv;
	}
}
