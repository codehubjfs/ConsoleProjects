package com.springmvc.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.Admin;
import com.springmvc.model.Issue;
import com.springmvc.model.Student;
import com.springmvc.model.Supervisor;
import com.springmvc.model.Warden;
import com.springmvc.model.Worker;
import com.springmvc.service.AdminService;
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
@RequestMapping("warden")
public class WardenController {
	
	@Autowired
	Supervisor supervisor;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	IssueService issueService;
	
	@Autowired
	WardenService wardenService;
	
	@Autowired
	SupervisorService supervisorService;
	
	@Autowired
	WorkerService workerService;
	
	@Autowired
	Student student;
	
	@Autowired
	Warden warden;
	
	@Autowired
	Worker worker;
	
	 @RequestMapping("wardendashboard")
	    public ModelAndView getCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
			 	String email= (String) request.getSession().getAttribute("email");
			 	ModelAndView mv = new ModelAndView();
				if (email == null) {
					
		            // Handle case where username is not found in session, perhaps redirect to login
					mv.setViewName("redirect:/forwardHomepage");
		            return mv;
		            
		        }
			 
				
				List<Admin>adminList=adminService.getAdminlist(email);
		        List<Student> studentList = studentService.getStudent();
		        List<Issue>issueList=issueService.getIssue();
		        
		        List<Warden>wardenList=wardenService.getWarden();
		        List<Warden>wardenUser=wardenList.stream().filter(x->x.getMailid().equals(email)).collect(Collectors.toList());
		        
		        List<Supervisor>supervisorList=supervisorService.getSupervisor();
		        
		        List<Worker>workerList=workerService.getWorker();
		        
		        System.out.println(wardenList);
		        
		        List<Issue>recentTicket=wardenService.getRecentTicket("Raised");
		        
		       mv.addObject("NewTicket",recentTicket);
		        
		        
		        System.out.println(studentList);
		        
		       
		        mv.addObject("ProfileOverview", wardenUser);
		        mv.addObject("supervisorCount", supervisorList.stream().count());
		        mv.addObject("wardenCount", wardenList.stream().count());
		        mv.addObject("studentCount", studentList.stream().count());
		        mv.addObject("issueCount",issueList.stream().count());
		        mv.addObject("NewIssueList",issueList.stream().filter(x->x.getStatus().equals("Raised")).count());
		        mv.addObject("issueProgress",issueList.stream().filter(x->x.getStatus().equals("In_progress")).count());
		        mv.addObject("issueCompleted",issueList.stream().filter(x->x.getStatus().equals("Completed")).count());
		       
		        mv.addObject("TotalIssueList",issueList.stream().count());
		        
		        mv.setViewName("warden/dashboard");
		        return mv;
	    }
	 
	 
	 @RequestMapping("viewticket")
	 public ModelAndView viewticket(HttpServletRequest request,HttpServletResponse response) {
		 
		 String email= (String) request.getSession().getAttribute("email");
		 	ModelAndView mv = new ModelAndView();
			if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
				mv.setViewName("redirect:/forwardHomepage");
	            return mv;
	            
	        }
			
			List<Warden>wardenList=wardenService.getWarden();
	        List<Warden>wardenUser=wardenList.stream().filter(x->x.getMailid().equals(email)).collect(Collectors.toList());
			mv.addObject("ProfileOverview", wardenUser);
			  List<Issue>issueList=issueService.getIssue();
			  mv.addObject("issueRaised",issueList.stream().filter(x->x.getStatus().equals("Raised")).collect(Collectors.toList()));
			  mv.setViewName("warden/viewticket");
			  return mv;
		 
	 }
	 
	 @RequestMapping("manageticket")
	 public ModelAndView manageticket(HttpServletRequest request,HttpServletResponse response) {
		 
		 String email= (String) request.getSession().getAttribute("email");
		 	ModelAndView mv = new ModelAndView();
			if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
				mv.setViewName("redirect:/forwardHomepage");
	            return mv;
	            
	        }
			
			List<Warden>wardenList=wardenService.getWarden();
	        List<Warden>wardenUser=wardenList.stream().filter(x->x.getMailid().equals(email)).collect(Collectors.toList());
	        
	        
	        
			mv.addObject("ProfileOverview", wardenUser);
			
			List<Supervisor>superList=supervisorService.getSupervisor();
			mv.addObject("supervisors",superList);
			
			
			  List<Issue>issueList=issueService.getIssue();
			  mv.addObject("NewTicket",issueList.stream().filter(x->x.getStatus().equals("Raised")).collect(Collectors.toList()));
			  mv.setViewName("warden/ManageTicket");
			  return mv;
		 
	 }
	 
	 
	 
	 @RequestMapping("AssignSupervisorController")
	 public ModelAndView AssignSupervisorController(HttpServletRequest request,HttpServletResponse response,@RequestParam("supervisorId")
	 int supervisorId,@RequestParam("issueId")int issueId) {
		 
		 String email= (String) request.getSession().getAttribute("email");
		 	ModelAndView mv = new ModelAndView();
			if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
				mv.setViewName("redirect:/forwardHomepage");
	            return mv;
	            
	        }
			
			String supervisornName=supervisorService.getSupervisorName(supervisorId);
			
			boolean updated=wardenService.assignSupervisor(supervisornName,issueId,"Assigned");
			 if(updated)
			  mv.setViewName("redirect:/warden/manageticket");
			 
			  return mv;
		 
	 }
	 
	 
	 
	 @RequestMapping("assignedTickets")
	 public ModelAndView assignedTickets(HttpServletRequest request,HttpServletResponse response) {
		 
		 String email= (String) request.getSession().getAttribute("email");
		 	ModelAndView mv = new ModelAndView();
			if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
				mv.setViewName("redirect:/forwardHomepage");
	            return mv;
	            
	        }
			
			List<Warden>wardenList=wardenService.getWarden();
	        List<Warden>wardenUser=wardenList.stream().filter(x->x.getMailid().equals(email)).collect(Collectors.toList());
			mv.addObject("ProfileOverview", wardenUser);
			
			
			List<Issue>issueList=issueService.getIssue();
			
			mv.addObject("assignedTicket",issueList.stream().filter(x->x.getStatus().equals("Assigned")).collect(Collectors.toList()));
			
			
			mv.setViewName("warden/AssignedTicket");
			return mv;
		 
	 }
	 
	 @RequestMapping("Room")
	 public ModelAndView Room(HttpServletRequest request,HttpServletResponse response) {
		 
		 String email= (String) request.getSession().getAttribute("email");
		 	ModelAndView mv = new ModelAndView();
			if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
				mv.setViewName("redirect:/forwardHomepage");
	            return mv;
	            
	        }
			List<Warden>wardenList=wardenService.getWarden();
	        List<Warden>wardenUser=wardenList.stream().filter(x->x.getMailid().equals(email)).collect(Collectors.toList());
			List<Student>studentList=studentService.getStudent();
			mv.addObject("studentdetails",studentList);
			mv.addObject("ProfileOverview", wardenUser);
			  List<Issue>issueList=issueService.getIssue();
			  mv.addObject("issueRaised",issueList.stream().filter(x->x.getStatus().equals("Raised")).collect(Collectors.toList()));
			  mv.setViewName("warden/room");
			  return mv;
		 
	 }
	 
	 @GetMapping("editRoom")
	 public ModelAndView editRoom(HttpServletRequest request,HttpServletResponse response,@RequestParam("mailid")String mailid
			 ,@RequestParam("roomNo")int roomNo,@RequestParam("blockno")String blockno) {
		 
		 	String email= (String) request.getSession().getAttribute("email");
		 	ModelAndView mv = new ModelAndView();
			if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
				mv.setViewName("redirect:/forwardHomepage");
	            return mv;
	            
	        }
			
			List<Warden>wardenList=wardenService.getWarden();
	        List<Warden>wardenUser=wardenList.stream().filter(x->x.getMailid().equals(email)).collect(Collectors.toList());
			mv.addObject("ProfileOverview", wardenUser);
			
			
			boolean edited=wardenService.editRoom(mailid,roomNo,blockno);
			
			if(edited)
				mv.setViewName("redirect:/warden/Room");
			
			return mv;
		 
	 }
	 
	 
	 @RequestMapping("supervisorDetails")
 	 public ModelAndView Wardentable(HttpServletRequest request, HttpServletResponse response) {
 		String email= (String) request.getSession().getAttribute("email");
	 	 ModelAndView mv = new ModelAndView();
		if (email == null) {
			
            // Handle case where username is not found in session, perhaps redirect to login
			mv.setViewName("redirect:/forwardHomepage");
            return mv;
            
        }
		
		 List<Warden>wardenList=wardenService.getWarden();
		 List<Warden>wardenUser=wardenList.stream().filter(x->x.getMailid().equals(email)).collect(Collectors.toList());
		 mv.addObject("ProfileOverview", wardenUser);
        
        
        List<Supervisor>supervisorList=supervisorService.getSupervisor();       
        mv.addObject("supervisordetails", supervisorList);
		 
		 mv.setViewName("warden/supervisortable");
		 
		 
		
		
		
		return mv;
 		 
 	 }
	 
	 
	 
	 @RequestMapping("wardenDetails")
 	 public ModelAndView supervisorTable(HttpServletRequest request, HttpServletResponse response) {
 		String email= (String) request.getSession().getAttribute("email");
	 	 ModelAndView mv = new ModelAndView();
		if (email == null) {
			
            // Handle case where username is not found in session, perhaps redirect to login
			mv.setViewName("redirect:/forwardHomepage");
            return mv;
            
        }
		
		 List<Warden>wardenList=wardenService.getWarden();
		 List<Warden>wardenUser=wardenList.stream().filter(x->x.getMailid().equals(email)).collect(Collectors.toList());
		 mv.addObject("ProfileOverview", wardenUser);
        
        
        List<Warden>warden=wardenService.getWarden();
       
        mv.addObject("wardendetails", warden);
		 
		 mv.setViewName("warden/wardentable");
		 
		 
		
		
		
		return mv;
 		 
 	 }
	 
	 
	 @RequestMapping("studentDetails")
 	 public ModelAndView studentTable(HttpServletRequest request, HttpServletResponse response) {
 		String email= (String) request.getSession().getAttribute("email");
	 	 ModelAndView mv = new ModelAndView();
		if (email == null) {
			
            // Handle case where username is not found in session, perhaps redirect to login
			mv.setViewName("redirect:/forwardHomepage");
            return mv;
            
        }
		
		 List<Warden>wardenList=wardenService.getWarden();
		 List<Warden>wardenUser=wardenList.stream().filter(x->x.getMailid().equals(email)).collect(Collectors.toList());
		 mv.addObject("ProfileOverview", wardenUser);
        
        
        List<Student>student=studentService.getStudent();
       
        mv.addObject("studentdetails", student);
		 
		 mv.setViewName("warden/studentable");
		 
		 
		
		
		
		return mv;
 		 
 	 }
	 
	 
	 @RequestMapping("issueDetails")
 	 public ModelAndView issueTable(HttpServletRequest request, HttpServletResponse response) {
 		String email= (String) request.getSession().getAttribute("email");
	 	 ModelAndView mv = new ModelAndView();
		if (email == null) {
			
            // Handle case where username is not found in session, perhaps redirect to login
			mv.setViewName("redirect:/forwardHomepage");
            return mv;
            
        }
		
		 List<Warden>wardenList=wardenService.getWarden();
		 List<Warden>wardenUser=wardenList.stream().filter(x->x.getMailid().equals(email)).collect(Collectors.toList());
		 mv.addObject("ProfileOverview", wardenUser);
        
        
        List<Issue>issue=issueService.getIssue();
       
        mv.addObject("totalissue", issue);
		 
		 mv.setViewName("warden/issuetable");
		 
		 
		
		
		
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
