package com.springmvc.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.*;
import com.springmvc.service.IssueService;
import com.springmvc.service.StudentService;
import com.springmvc.service.SupervisorService;
import com.springmvc.service.WardenService;
import com.springmvc.service.WorkerService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	Student student;
	
	@Autowired
	Issue issue;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	IssueService issueService;
	
	@Autowired
	WorkerService workerService;
	
	@Autowired
	WardenService wardenService;
	
	@Autowired
	SupervisorService supervisorService;
	
	 @RequestMapping("studentdashboard")
	    public ModelAndView getCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 		ModelAndView mv = new ModelAndView();
		 		
			 	String email= (String) request.getSession().getAttribute("email");
				if (email == null) {
					
		            // Handle case where username is not found in session, perhaps redirect to login
					mv.setViewName("redirect:/forwardHomepage");
		            return mv;
		        }
			 
			   
		        List<Student> studentList = studentService.getStudent();
		        List<Issue>issueList=issueService.getIssue();
		        List<Student>profile=studentService.getProfile(email);
		        List<Warden>wardenList=wardenService.getWarden();
		        List<Supervisor>supervisorList=supervisorService.getSupervisor();
		        
		        List<Worker>workerList=workerService.getWorker();
		        List<Issue>RecentTickets=issueService.getRecentTicketsByUsername(email);
		        
		       
		        
		        
		        System.out.println(studentList);
		       
		        mv.addObject("RecentTickets", RecentTickets);
		        mv.addObject("ProfileOverview", profile);
		        mv.addObject("supervisorCount", supervisorList.stream().count());
		        mv.addObject("workerCount",workerList.stream().count());
		        mv.addObject("wardenCount", wardenList.stream().count());
		        mv.addObject("studentCount", studentList.stream().count());
		        mv.addObject("issueCount",issueList.stream().count());
		        mv.addObject("issueOpened",issueList.stream().filter(x->x.getStatus().equals("Raised")).count());
		        mv.addObject("issueProgress",issueList.stream().filter(x->x.getStatus().equals("In_progress")).count());
		        mv.addObject("issueCompleted",issueList.stream().filter(x->x.getStatus().equals("Completed")).count());
		        mv.setViewName("Student/dashboard");
		        return mv;
	    }
	 
	 
	 
	 
	 //Ticket Raise page
	 @RequestMapping("tickeraise")
	 public ModelAndView tickeraise(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 
		 
		 String email= (String) request.getSession().getAttribute("email");
		 ModelAndView mv = new ModelAndView();
		 
			if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
				mv.setViewName("redirect:/forwardHomepage");
	            return mv;
	            
	        }
			
			
			 List<Student>profile=studentService.getProfile(email);
			 mv.addObject("ProfileOverview", profile);
			List<Issue>tickets=issueService.getTicketsByUsername(email);
			
			
			
			  mv.addObject("tickets", tickets);
			  mv.setViewName("Student/ticketraise");
			  return mv;
		}
	 
	 
	 //New ticket
	 @PostMapping("/newticket")
	 public ModelAndView newticket(HttpServletRequest request,HttpServletResponse response ,@RequestParam("issuetitle")String issuetitle,
			 @RequestParam("description") String description ,@RequestParam("priority")String priority,@RequestParam("issuedate") Date issuedate) throws ServletException, IOException{
		 	String email= (String) request.getSession().getAttribute("email");
			if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
				request.getRequestDispatcher("//logout").forward(request, response);
	            
	        }
			System.out.println("new");
			ModelAndView mv = new ModelAndView();
			List<Student>profile=studentService.getProfile(email);
			mv.addObject("ProfileOverview", profile);
			
			List<String> errors = new ArrayList<>();

	        if (issuetitle == null || issuetitle.isEmpty()) {
	            errors.add("Issue title is required.");
	        }
	        if (description == null || description.isEmpty()) {
	            errors.add("Description is required.");
	        }
	        if (priority == null || priority.isEmpty()) {
	            errors.add("Priority is required.");
	        }
	        if (issuedate == null ) {
	            errors.add("Issue date is required.");
	        }
	        
	        if (!errors.isEmpty()) {
		           
	            mv.addObject("errors",errors);
	           mv.setViewName("Student/ticketraise");
	          
	        }
	        else {
	        	Date ticketRaiseDate=Date.valueOf(LocalDate.now());
		        String allocatedTo = "NotAllocated";
		        String status ="Raised";
		        
		        issue.setIssuetitle(issuetitle);
		        issue.setDescription(description);
		        issue.setTicketraisedate(ticketRaiseDate);
		        issue.setRaisedby(email);
		        issue.setAllocatedto(allocatedTo);
		        issue.setPriority(priority);
		        issue.setStatus(status);
		        issue.setIssuedate(issuedate);
		        
		        
		        
	        	boolean inserted=issueService.insertNewTicket(issue);
	        	if(inserted) {
	        		System.out.println("inserted");
	        		mv.setViewName("redirect:/student/tickeraise");
	        	 
	        	}
	        	
	        }
	        return mv;
	  		
	 }
	 
	 @RequestMapping("oldticket")
	 public ModelAndView oldTicket(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	 String email= (String) request.getSession().getAttribute("email");
			
	 ModelAndView mv = new ModelAndView();
	 		if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
	 			mv.setViewName("redirect:/forwardHomepage");
			         return mv;
	            
	        }
			
			
			List<Student>profile=studentService.getProfile(email);
			mv.addObject("ProfileOverview", profile);
			
			
			List<Issue>tickets=issueService.historyOfTicket(email);
			
			mv.addObject("tickets",tickets.stream().filter(x->x.getStatus().equals("Completed")).collect(Collectors.toList()));
			mv.setViewName("Student/oldissue");
			return mv;
	  		
	 }
	 
	 @RequestMapping("notification")
	 public ModelAndView notification(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 String email= (String) request.getSession().getAttribute("email");
		 ModelAndView mv = new ModelAndView();		
		 		if (email == null) {
					
		            // Handle case where username is not found in session, perhaps redirect to login
		 			mv.setViewName("redirect:/forwardHomepage");
				            return mv;
		            
		        }
				
				
				List<Student>profile=studentService.getProfile(email);
				mv.addObject("ProfileOverview", profile);
				
				
			
				mv.setViewName("Student/notification");
				return mv;
		  		
		 }
	 
	 @RequestMapping("studenteditprofile")
	 public ModelAndView studenteditprofile(HttpServletRequest request,HttpServletResponse response,@RequestParam("editname")String name,
			 @RequestParam("editnumber")String number) throws ServletException, IOException {
		 
		 
		 String email= (String) request.getSession().getAttribute("email");
		 ModelAndView mv = new ModelAndView();		
		 if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
	 			mv.setViewName("redirect:/forwardHomepage");
			            return mv;
	            
	        }
				
				
				
				List<Student>profile=studentService.getProfile(email);
				mv.addObject("ProfileOverview", profile);
				
				student.setMailid(email);
				student.setName(name);
				student.setPhonenumber(number);
				boolean updated =studentService.editProfile(student);
				
				if(updated) {
					System.out.println("Updated");
					mv.setViewName("redirect:/student/studentdashboard");
				}
				
				
				
				return mv;
		  		
		 }
	 
	 	
	 @RequestMapping("studentdata")
	 public ModelAndView studentData(HttpServletRequest request,HttpServletResponse response) {
		 
		 String email= (String) request.getSession().getAttribute("email");
		 ModelAndView mv = new ModelAndView();		
		 if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
	 			mv.setViewName("redirect:/forwardHomepage");
			            return mv;
	            
	        }
		 		
		 
		 		List<Student>profile=studentService.getProfile(email);
		 		mv.addObject("ProfileOverview", profile);
		 
		 		List<Student>studentdetails=studentService.getStudent();
		 		mv.addObject("studentdetails",studentdetails);
		 		mv.setViewName("Student/studentable");
		 		return mv;
		 
	 }
	 
	 @RequestMapping("supervisordata")
	 public ModelAndView supervisordata(HttpServletRequest request,HttpServletResponse response) {
		 
		 String email= (String) request.getSession().getAttribute("email");
		 ModelAndView mv = new ModelAndView();		
		 if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
	 			mv.setViewName("redirect:/forwardHomepage");
			            return mv;
	            
	        }
		 		
		 
		 		List<Student>profile=studentService.getProfile(email);
		 		mv.addObject("ProfileOverview", profile);
		 
		 		List<Supervisor>supervisorDetails=supervisorService.getSupervisor();
		 		mv.addObject("supervisordetails",supervisorDetails);
		 		mv.setViewName("Student/supervisortable");
		 		return mv;
		 
	 }
	 
	 @RequestMapping("wardendata")
	 public ModelAndView wardendata(HttpServletRequest request,HttpServletResponse response) {
		 
		 String email= (String) request.getSession().getAttribute("email");
		 ModelAndView mv = new ModelAndView();		
		 if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
	 			mv.setViewName("redirect:/forwardHomepage");
			            return mv;
	            
	        }
		 		
		 
		 		List<Student>profile=studentService.getProfile(email);
		 		mv.addObject("ProfileOverview", profile);
		 
		 		List<Warden>wardendetails=wardenService.getWarden();
		 		mv.addObject("wardendetails",wardendetails);
		 		mv.setViewName("Student/wardentable");
		 		return mv;
		 
	 }
	 
	 @RequestMapping("workerdata")
	 public ModelAndView issuedata(HttpServletRequest request,HttpServletResponse response) {
		 
		 String email= (String) request.getSession().getAttribute("email");
		 ModelAndView mv = new ModelAndView();		
		 if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
	 			mv.setViewName("redirect:/forwardHomepage");
			            return mv;
	            
	        }
		 		
		 		List<Student>profile=studentService.getProfile(email);
		 		List<Worker>workerDetails=workerService.getWorker();
		 		mv.addObject("ProfileOverview", profile);
		 
		 		
		 		mv.addObject("workerDetails",workerDetails);
		 		mv.setViewName("Student/Workertable");
		 		return mv;
		 
	 }
	 	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 	@RequestMapping("logout")
		public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
			
			HttpSession session=request.getSession();
			
			session.invalidate();
			ModelAndView mv=new ModelAndView();
			
			mv.setViewName("redirect:/forwardHomepage");
			
			return mv;
			
		}
	 
	 
	 
	 

}
