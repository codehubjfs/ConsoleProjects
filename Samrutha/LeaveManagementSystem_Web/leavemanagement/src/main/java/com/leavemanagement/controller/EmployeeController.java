package com.leavemanagement.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.leavemanagement.model.ApplicationStatus;
import com.leavemanagement.model.Employee;
import com.leavemanagement.model.LeaveBalance;
import com.leavemanagement.model.Leaves;
import com.leavemanagement.service.EmployeeService;
import com.leavemanagement.service.LeaveService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@ResponseBody
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	LeaveService leaveService;
	
	@RequestMapping("/edashboard")
	public ModelAndView getDashboard(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
        
		
        
    	
        if ((String)session.getAttribute("username")== null) {
        	mv.setViewName("redirect:/home");
        	return mv;
            
        }
        else {
        	Employee emp = employeeService.getEmployeeDetail((String)session.getAttribute("username"));
            session.setAttribute("employee", emp);
            
        	LeaveBalance leaveBalance = leaveService.displayLeaveCount(emp.getEmpID());
            
            System.out.println(leaveBalance.getBalanceLeave());
    		List<Leaves>  leaveList = leaveService.getLeavesById(emp.getEmpID());
    		leaveList.sort((leave1, leave2) -> leave2.getStartDate().compareTo(leave1.getStartDate()));
    		
    		request.setAttribute("leaves", leaveList);
    		System.out.println("Controller " + leaveList);
    		
    		
    		
    		mv.addObject("leaveBalance", leaveBalance);
    		mv.setViewName("Employee/index");
        }
		return mv;
	}
	
	@RequestMapping("/eprofile")
	public ModelAndView getProfile(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		//String username = (String)request.getSession().getAttribute("username");
		Employee emp = (Employee) request.getSession().getAttribute("employee");
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		
        ModelAndView mv = new ModelAndView();
        if (emp==null) {
        	mv.setViewName("redirect:/home");
            
        } 
        else{
	            mv.setViewName("Employee/Profile");
	        }
        return mv;
	}
	
	@RequestMapping("/updateEprofile")
	public ModelAndView getProfileDetails(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
	    String username = (String) request.getSession().getAttribute("username");
	    Employee emp = (Employee) request.getSession().getAttribute("employee");

	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	    response.setHeader("Expires", "0");

	    ModelAndView mv = new ModelAndView();
	    if (emp == null) {
	        mv.setViewName("redirect:/home");
	    } else {
	        String oldPassword = request.getParameter("oldPassword");
	        String newPassword = request.getParameter("newPassword");
	        String CfPassword = request.getParameter("CfPassword");

	        System.out.println(oldPassword);
	        System.out.println(newPassword);
	        System.out.println(CfPassword);

	        if (emp.getPassword().equals(oldPassword) && newPassword.equals(CfPassword)) {
	            employeeService.updatePassword(newPassword, emp.getEmpID());
	            request.setAttribute("successMessage", "Updated Successfully...!");
	        } else {
	        	request.setAttribute("errorMessage", "Old password is incorrect or passwords do not match.");
	        }
	        mv.setViewName("Employee/Profile");
	    }
	    return mv;
	}

	@RequestMapping("/passwordchecker")
	public List<String> getPassword(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		
		String username = (String) request.getSession().getAttribute("username");
		Employee emp = (Employee) request.getSession().getAttribute("employee");
		List<String> password = new ArrayList<String>();
		try {
			password.add(emp.getPassword());
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		return password;
	}
	
	@RequestMapping("/eleave")
	public ModelAndView getAllLeave(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		String username = (String)request.getSession().getAttribute("username");
		Employee emp = (Employee) request.getSession().getAttribute("employee");
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		
        if (username==null) {
        	mv.setViewName("redirect:/home");
            
        } 
        else {
                List<Leaves> leaves = leaveService.getLeavesById(emp.getEmpID());
                leaves.sort((leave1, leave2) -> leave2.getStartDate().compareTo(leave1.getStartDate()));
                request.setAttribute("leaves", leaves);
                mv.setViewName("Employee/LeaveManagement");
            } 
		return mv;
	}
	
	@RequestMapping("/ehistory")
	public ModelAndView getHistoryPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String username = (String)request.getSession().getAttribute("username");
		Employee emp = (Employee) request.getSession().getAttribute("employee");
		ModelAndView mv = new ModelAndView();
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
        if (username==null) {
        	mv.setViewName("redirect:/home");
            
        } 
        else {
	            List<Leaves> leaves = leaveService.getLeavesById(emp.getEmpID());
	            System.out.println("Controller:");
	            for(Leaves l: leaves) {
	            	System.out.println(l);
	            }
	            System.out.println();
	            leaves.sort((leave1, leave2) -> leave2.getStartDate().compareTo(leave1.getStartDate()));
	            
	            request.setAttribute("leaves", leaves);
	            
	            if (leaves != null) {
		            List<Leaves> approvedLeaves = leaves.stream().filter((l) -> l.getStatus().equals(ApplicationStatus.APPROVED) && (l.getStartDate().isEqual(LocalDate.now()) || l.getStartDate().isBefore(LocalDate.now()))).collect(Collectors.toList());
		            List<Leaves> rejectedLeaves = leaves.stream().filter((l) -> l.getStatus().equals(ApplicationStatus.REJECTED) && (l.getStartDate().isEqual(LocalDate.now()) || l.getStartDate().isBefore(LocalDate.now()))).collect(Collectors.toList());
		            List<Leaves> cancelledLeaves = leaves.stream().filter((l) -> l.getStatus().equals(ApplicationStatus.CANCELLED) && (l.getStartDate().isEqual(LocalDate.now()) || l.getStartDate().isBefore(LocalDate.now()))).collect(Collectors.toList());
		            request.setAttribute("approvedleaves", approvedLeaves);
		            request.setAttribute("rejectedleaves", rejectedLeaves);
		            request.setAttribute("cancelledleaves", cancelledLeaves);
		            
		            System.out.println("Approved:");
		            for (Leaves l : approvedLeaves) {
		            	System.out.println(l);
		            }
		            System.out.println("Rejected:");
		            for (Leaves l : rejectedLeaves) {
		            	System.out.println(l);
		            }
		            System.out.println("Cancelled:");
		            for (Leaves l : cancelledLeaves) {
		            	System.out.println(l);
		            }
	            } 
	            mv.setViewName("Employee/History");
	        }
	        
	        return mv;
	}
}
