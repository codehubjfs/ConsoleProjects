package com.leavemanagement.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.leavemanagement.model.ApplicationStatus;
import com.leavemanagement.model.Employee;
import com.leavemanagement.model.Leaves;
import com.leavemanagement.service.EmployeeService;
import com.leavemanagement.service.LeaveService;
import com.leavemanagement.service.ManagerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@ResponseBody
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	ManagerService managerService;
	
	@Autowired
	LeaveService leaveService;
	
	@RequestMapping("/mdashboard")
	public ModelAndView getDashboard(HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response) {
		
        
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		
        ModelAndView mv = new ModelAndView();
        if ((String)session.getAttribute("username")==null) {
        	mv.setViewName("redirect:/home");
            
        } 
        else {
        	//Team Member count
        	Employee emp = employeeService.getEmployeeDetail((String)session.getAttribute("username"));
            session.setAttribute("employee", emp);
            List<Employee> teams = managerService.getTeams(emp.getEmpID());
            request.setAttribute("teams", teams);
            model.addAttribute("teamCount", teams.size());
            
            
            //Pending Leave count
            List<Leaves> leaves = leaveService.getLeavesByManagerId(emp.getEmpID());
            request.setAttribute("leaves", leaves);
            request.setAttribute("leaveRequestCount", leaves.stream().filter((l)->l.getStatus()==ApplicationStatus.PENDING).count());

            //todays absent
            List<Leaves> absent = leaves.stream()
      	          .filter((l) -> (l.getStatus() == ApplicationStatus.APPROVED) &&
                          (LocalDate.now().isAfter(l.getStartDate()) || LocalDate.now().isEqual(l.getStartDate())) &&
                          (LocalDate.now().isBefore(l.getEndDate()) || LocalDate.now().isEqual(l.getEndDate()))).collect(Collectors.toList());
            
            request.setAttribute("absent", absent);
            
            //absentees count
            request.setAttribute("absentCount", absent.size());
            
    		mv.setViewName("Manager/index");
        }
        
		
		return mv;
	}
	
	@RequestMapping("/mprofile")
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
	            mv.setViewName("Manager/Profile");
	        }
        return mv;
	}
	
	@RequestMapping("/mviewTeams")
	public ModelAndView viewTeams(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String username = (String)request.getSession().getAttribute("username");
		Employee emp = (Employee) request.getSession().getAttribute("employee");
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
        
        if ((String)session.getAttribute("username")==null) {
        	mv.setViewName("redirect:/home");
            
        } 
        else {
        	List<Employee> teams = managerService.getTeams(emp.getEmpID());
        	request.setAttribute("teams", teams);
        	
        	mv.setViewName("Manager/ViewTeams");
        }
		
    	return mv;
	}
	
	@RequestMapping("/updateMprofile")
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
	        mv.setViewName("Manager/Profile");
	    }
	    return mv;
	}
	
	@RequestMapping("/mpasswordchecker")
	public List<String> getPassword(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		
		String username = (String) request.getSession().getAttribute("username");
		Employee emp = (Employee) request.getSession().getAttribute("employee");
		List<String> password = new ArrayList<String>();
		password.add(emp.getPassword());
		System.out.println(password);
		return password;
	}
	
	@RequestMapping("/mLeaveManagement")
	public ModelAndView getLeaves(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String username = (String)request.getSession().getAttribute("username");
		Employee emp = (Employee) request.getSession().getAttribute("employee");
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
        
        if ((String)session.getAttribute("username")==null) {
        	mv.setViewName("redirect:/home");
            
        } 
        else {
			List<Leaves> leaves = leaveService.getLeavesByManagerId(emp.getEmpID());
			leaves.sort((leave1, leave2) -> leave2.getStartDate().compareTo(leave1.getStartDate()));
	        request.setAttribute("leaves", leaves);
	    	mv.setViewName("Manager/LeaveManagement");
        }
    	return mv;

	}
	
	
	@RequestMapping("/mCalender")
	public ModelAndView getCalender(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		ModelAndView mv = new ModelAndView();
		String username = (String)request.getSession().getAttribute("username");
		Employee emp = (Employee) request.getSession().getAttribute("employee");
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
        
        if ((String)session.getAttribute("username")==null) {
        	mv.setViewName("redirect:/home");
            
        } 
        else {
        	List<Leaves> leaves = leaveService.getLeavesByManagerId(emp.getEmpID())
        	        .stream()
        	        .filter(l -> l.getStatus() == ApplicationStatus.APPROVED)
        	        .filter(l -> {
        	            LocalDate startDate = l.getStartDate();
        	            LocalDate now = LocalDate.now();
        	            return startDate.getYear() == now.getYear() && startDate.getMonth() == now.getMonth();
        	        })
        	        .collect(Collectors.toList());

        	Map<Integer, List<String>> absenteesMap = new HashMap<>();

        	for (Leaves leave : leaves) {
        	    LocalDate startDate = leave.getStartDate();
        	    LocalDate endDate = leave.getEndDate();

        	    // Iterate through each day between start and end date inclusive
        	    LocalDate currentDate = startDate;
        	    while (!currentDate.isAfter(endDate)) {
        	        absenteesMap.computeIfAbsent(currentDate.getDayOfMonth(), k -> new ArrayList<>()).add(leave.getEmp().getUsername());
        	        currentDate = currentDate.plusDays(1);
        	    }
        	}

        	model.addAttribute("absenteesMap", absenteesMap);
        	System.out.println("Absent map: ");
        	System.out.println(absenteesMap);
        	mv.setViewName("Manager/Calender");
        }
    	return mv;

	}
		
}
