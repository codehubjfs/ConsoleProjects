package com.springmvc.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
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

@ResponseBody
@Controller
@RequestMapping("Admin")
public class AdminController {
	
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
	
	
	
	 @RequestMapping("admindashboard")
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
		        List<Supervisor>supervisorList=supervisorService.getSupervisor();
		        
		        List<Worker>workerList=workerService.getWorker();
		        
		        System.out.println(wardenList);
		        
		      
		        
		        
		        System.out.println(studentList);
		        
		       
		        mv.addObject("AdminDetails", adminList);
		        mv.addObject("SupervisorCount", supervisorList.stream().count());
		        mv.addObject("Wardencount", wardenList.stream().count());
		        mv.addObject("StudentCount", studentList.stream().count());
		        mv.addObject("issueCount",issueList.stream().count());
		        mv.addObject("NewIssueList",issueList.stream().filter(x->x.getStatus().equals("Raised")).count());
		        mv.addObject("PendingIssueList",issueList.stream().filter(x->x.getStatus().equals("In_progress")).count());
		        mv.addObject("CompletedIssueList",issueList.stream().filter(x->x.getStatus().equals("Completed")).count());
		        mv.addObject("WorkersCount",workerList.stream().count());
		        mv.addObject("TotalIssueList",issueList.stream().count());
		        
		        mv.setViewName("Admin/dashboard");
		        return mv;
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 //User management
	 @RequestMapping("usermanagement")
	    public ModelAndView getStudent(HttpServletRequest request, HttpServletResponse response)  {
	        
			 	String email= (String) request.getSession().getAttribute("email");
			 	 ModelAndView mv = new ModelAndView();
				if (email == null) {
					
		            // Handle case where username is not found in session, perhaps redirect to login
					mv.setViewName("redirect:/forwardHomepage");
		            return mv;
		            
		        }
			 
			   
				List<Admin>adminList=adminService.getAdminlist(email);
		        List<Student> studentList = studentService.getStudent();
		        
		        
		        System.out.println(studentList);
		       
		       
		        mv.addObject("studentdetails", studentList);
		        mv.addObject("AdminDetails", adminList);
		        
		        if (request.getAttribute("studentinserted") != null) {
		            mv.addObject("studentinserted", request.getAttribute("studentinserted"));
		        }
		       
		        
		        mv.setViewName("Admin/usermanagement");
		        return mv;
	    }
	 
	 
	 @GetMapping("/uniqueNumber")
	    public List<String> uniqueNumber(HttpServletRequest request, HttpServletResponse response)  {
	        
			 	
		        List<Student> studentList = studentService.getStudent();
		        
		        
		        List<String>mobileNumbers=studentList.stream().map(x->x.getPhonenumber()).collect(Collectors.toList());
		      
		       
		        
		      return mobileNumbers;
      
	    }
	 
	 @GetMapping("/uniqueMail")
	    public List<String> uniqueMail(HttpServletRequest request, HttpServletResponse response)  {
	        
			 	
			 
			   
				
		        List<Student> studentList = studentService.getStudent();
		        
		        
		        List<String>mail=studentList.stream().map(x->x.getMailid()).collect(Collectors.toList());
		      
		       
		        
		      return mail;
   
	    }
	 
	 
	 	@RequestMapping("insertstudent")
	   public ModelAndView insertStudent(HttpServletRequest request,HttpServletResponse response,@RequestParam("studentName")String name,
	   @RequestParam("department")String department,@RequestParam("phoneNumber")String phonenumber,@RequestParam("block")String blockno,@RequestParam("roomNo")int roomno,
	     @RequestParam("mailid")String mailid,@RequestParam("password")String password,RedirectAttributes redirectAttributes) {
		   
		   
		   ModelAndView mv=new ModelAndView();
		   student.setName(name);
		   student.setDepartment(department);
		   student.setPhonenumber(phonenumber);
		   student.setRoomno(roomno);
		   student.setBlockno(blockno);
		   student.setMailid(mailid);
		   student.setPassword(password);
		   student.setRole("Student");
		   System.out.println(student);
		   
		   boolean inserted=adminService.insertStudent(student);
		   
		   if (inserted) {
		        redirectAttributes.addFlashAttribute("studentinserted", "success");
		        mv.setViewName("redirect:/Admin/usermanagement");
		    }
		   
		   	return mv;
		   
		   
	   }
	 	
	 	
	 	@GetMapping("editStudent")
	    public ModelAndView editStudent(HttpServletRequest request, HttpServletResponse response,@RequestParam("mailid")String mailid,@RequestParam("name")String name
	    		,@RequestParam("roomNo")int roomNo,@RequestParam("blockno")String blockno) {
	        
			 	String email= (String) request.getSession().getAttribute("email");
			 	 ModelAndView mv = new ModelAndView();
				if (email == null) {
					
		            // Handle case where username is not found in session, perhaps redirect to login
					mv.setViewName("Home/Login");
		            return mv;
		            
		        }
			 
			   student.setMailid(mailid);
			   student.setName(name);
			   student.setRoomno(roomNo);
			   student.setBlockno(blockno);
				
		        
		       boolean inserted=adminService.editStudent(student); 
		        
		       if(inserted) {
		    	   mv.setViewName("redirect:/Admin/usermanagement");
		       }
		     
		       return mv;
	    }
	 	
	 	
	 	
	 	@GetMapping("deleteStudent")
	    public ModelAndView deleteStudent(HttpServletRequest request, HttpServletResponse response,@RequestParam("id")String id) {
	        
			 	String email= (String) request.getSession().getAttribute("email");
			 	 ModelAndView mv = new ModelAndView();
				if (email == null) {
					
		            // Handle case where username is not found in session, perhaps redirect to login
					mv.setViewName("redirect:/forwardHomepage");
		            return mv;
		            
		        }
			 student.setMailid(id);
			 boolean deleted=adminService.deleteStudent(student);
			 
			 if(deleted) {
				 mv.setViewName("redirect:/Admin/usermanagement");
			 }
			 return mv;
			 
	    }
	 	
	 	
	 	
	 	@RequestMapping("wardenmanagement")
	    public ModelAndView getWarden(HttpServletRequest request, HttpServletResponse response)  {
	        
			 	String email= (String) request.getSession().getAttribute("email");
			 	 ModelAndView mv = new ModelAndView();
				if (email == null) {
					
		            // Handle case where username is not found in session, perhaps redirect to login
					mv.setViewName("redirect:/forwardHomepage");
		            return mv;
		            
		        }
			 
			   
				List<Admin>adminList=adminService.getAdminlist(email);
		        List<Warden> wardendList = wardenService.getWarden();
		        
		       
		        mv.addObject("wardendetails", wardendList);
		        mv.addObject("AdminDetails", adminList);
		       
		        if(request.getAttribute("InsertWarden")!=null) {
		        	
		        	System.out.println("ulan");
		        	mv.addObject("InsertWarden",request.getAttribute("InsertWarden"));
		        }
		        
		        mv.setViewName("Admin/wardenmanagement");
		        return mv;
	    }
	 	
	 	
	 	
	 	@GetMapping("/wardenUniqueMail")
	    public List<String> wardenUniqueMail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
			 	
		        List<Warden> wardenList = wardenService.getWarden();
		        
		        System.out.print("warden");
		        List<String>mail=wardenList.stream().map(x->x.getMailid()).collect(Collectors.toList());
		      
		        for(String i:mail) {
		        	System.out.println(i);
		        }
		        
		      return mail;
      
	    }
	 	
	 	
	 	@PostMapping("insertWarden")
		   public ModelAndView insertWarden(HttpServletRequest request,HttpServletResponse response,@RequestParam("wardenName")
		   String wardenName,@RequestParam("mailid")String mailid,@RequestParam("password") String password,RedirectAttributes redirectAttributes){ 
			   
			   
			   ModelAndView mv=new ModelAndView();
			   
			  warden.setMailid(mailid);
			  warden.setName(wardenName);
			  warden.setPassword(password);
			  warden.setRole("warden"); 
			  boolean inserted=adminService.insertWarden(warden);
			   
			
			   if(inserted) {
				   
				   redirectAttributes.addFlashAttribute("InsertWarden","success");
				   mv.setViewName("redirect:/Admin/wardenmanagement");
			   
			   
			   }
			   	return mv;
			   
			   
		   }
	 	
	 	
	 	@GetMapping("editWarden")
	 	public ModelAndView editWarden(HttpServletRequest request, HttpServletResponse response,@RequestParam("mailid")String wardenid,@RequestParam("name")String name) {
	        
			 	String email= (String) request.getSession().getAttribute("email");
			 	 ModelAndView mv = new ModelAndView();
				if (email == null) {
					
		            // Handle case where username is not found in session, perhaps redirect to login
					mv.setViewName("redirect:/forwardHomepage");
		            return mv;
		            
		        }
			 
				System.out.println("editwarden");
			   warden.setWardenid(wardenid);
			   warden.setName(name);
			  
				System.out.println(wardenid);
				System.out.println(name);
		        
		       boolean inserted=adminService.editWarden(warden); 
		       System.out.println("boo"); 
		       if(inserted) {
		    	   System.out.print("inserted");
		    	   mv.setViewName("redirect:/Admin/wardenmanagement");
		       }
		     
		       return mv;
	    }
	 	
	 	
	 	
	 	@GetMapping("deleteWarden")
	    public ModelAndView deleteWarden(HttpServletRequest request, HttpServletResponse response,@RequestParam("id")String id) {
	        
			 	String email= (String) request.getSession().getAttribute("email");
			 	 ModelAndView mv = new ModelAndView();
				if (email == null) {
					
		            // Handle case where username is not found in session, perhaps redirect to login
					mv.setViewName("redirect:/forwardHomepage");
		            return mv;
		            
		        }
			 warden.setWardenid(id);
			 
			 boolean deleted=adminService.deleteWarden(warden);
			 
			 if(deleted) {
				 mv.setViewName("redirect:/Admin/wardenmanagement");
			 }
			 return mv;
			 
	    }
	 	
	 	
	 	@RequestMapping("supervisormanagement")
	    public ModelAndView getSupervisor(HttpServletRequest request, HttpServletResponse response)  {
	        
			 	String email= (String) request.getSession().getAttribute("email");
			 	 ModelAndView mv = new ModelAndView();
				if (email == null) {
					
		            // Handle case where username is not found in session, perhaps redirect to login
					mv.setViewName("redirect:/forwardHomepage");
		            return mv;
		            
		        }
			 
			   
				List<Admin>adminList=adminService.getAdminlist(email);
		        List<Supervisor> supervisorList = supervisorService.getSupervisor();
		        
		       
		        mv.addObject("supervisorDetails", supervisorList);
		        mv.addObject("AdminDetails", adminList);
		       
		        
		        mv.setViewName("Admin/supervisormanagement");
		        return mv;
	    }
	 	
	 	
	 	@GetMapping("/supervisorUniqueMail")
	    public List<String> supervisorUniqueMail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
			 	
		        List<Supervisor> supervisorList = supervisorService.getSupervisor();
		        
		        System.out.print("warden");
		        List<String>mail=supervisorList.stream().map(x->x.getMailid()).collect(Collectors.toList());
		      
		        for(String i:mail) {
		        	System.out.println(i);
		        }
		        
		      return mail;
      
	    }
	 	
	 	
	 	
	 	   @PostMapping("insertSupervisor")
		   public ModelAndView insertSupervisor(HttpServletRequest request,HttpServletResponse response,@RequestParam("supervisorName")
		   String supervisorName,@RequestParam("mailid")String mailid,@RequestParam("password") String password,@RequestParam("department")String department){ 
			   
			   
			   ModelAndView mv=new ModelAndView();
			   
			  supervisor.setMailid(mailid);
			  supervisor.setName(supervisorName);
			  supervisor.setPassword(password);
			  supervisor.setRole("Supervisor"); 
			  supervisor.setDepartment(department);
			  boolean inserted=adminService.insertSupervisor(supervisor);
			   
			
			   if(inserted) {
				   mv.setViewName("redirect:/Admin/supervisormanagement");
			   }
			   	return mv;
			   
			   
		   }
	 	   
	 	   
	 	   
	 	  @GetMapping("deleteSupervisor")
		    public ModelAndView deleteSupervisor(HttpServletRequest request, HttpServletResponse response,@RequestParam("id")String id) {
		        
				 	String email= (String) request.getSession().getAttribute("email");
				 	 ModelAndView mv = new ModelAndView();
					if (email == null) {
						
			            // Handle case where username is not found in session, perhaps redirect to login
						mv.setViewName("redirect:/forwardHomepage");
			            return mv;
			            
			        }
				 supervisor.setMailid(id);
				 
				 boolean deleted=adminService.deleteSupervisor(supervisor);
				 
				 if(deleted) {
					 mv.setViewName("redirect:/Admin/supervisormanagement");
				 }
				 return mv;
				 
		    }
	 	  
	 	  
	 	 @GetMapping("editSupervisor")
		 	public ModelAndView editSupervisor(HttpServletRequest request, HttpServletResponse response,@RequestParam("mailid")String mailid,@RequestParam("name")String name,
		 			@RequestParam("department")String department) {
		        
				 	String email= (String) request.getSession().getAttribute("email");
				 	 ModelAndView mv = new ModelAndView();
					if (email == null) {
						
			            // Handle case where username is not found in session, perhaps redirect to login
						mv.setViewName("redirect:/forwardHomepage");
			            return mv;
			            
			        }
				 
					System.out.println("editsupervisor");
					  supervisor.setMailid(mailid);
					  supervisor.setName(name);
					  supervisor.setDepartment(department);
				  
					System.out.println(supervisor.getMailid()+""+supervisor.getName()+""+supervisor.getRole());
			        
			       boolean inserted=adminService.editSupervisor(supervisor); 
			      
			       if(inserted) {
			    	   System.out.print("inserted");
			    	   mv.setViewName("redirect:/Admin/supervisormanagement");
			       }
			     
			       return mv;
		    }
	 	 
	 	 
	 	 
	 	@RequestMapping("workermanagement")
	    public ModelAndView getWorker(HttpServletRequest request, HttpServletResponse response)  {
	        
			 	String email= (String) request.getSession().getAttribute("email");
			 	 ModelAndView mv = new ModelAndView();
				if (email == null) {
					
		            // Handle case where username is not found in session, perhaps redirect to login
					mv.setViewName("redirect:/forwardHomepage");
		            return mv;
		            
		        }
			 
			   
				List<Admin>adminList=adminService.getAdminlist(email);
		        List<Worker> workerList = workerService.getWorker();
		        
		       
		        mv.addObject("workersDetails", workerList);
		        mv.addObject("AdminDetails", adminList);
		       
		        
		        mv.setViewName("Admin/workermanagement");
		        return mv;
	    }
	 	
	 	
	 	
	 	@GetMapping("/workerUniqueNumber")
	    public List<String> workerUniqueNumber(HttpServletRequest request, HttpServletResponse response)  {
	        
			 	
		        List<Worker> workerList = workerService.getWorker();
		        
		        
		        List<String>mobileNumbers=workerList.stream().map(x->x.getPhonenumber()).collect(Collectors.toList());
		      
		       
		        
		      return mobileNumbers;
      
	    }
	 	
	 	
	 	
	 	@PostMapping("insertWorker")
		   public ModelAndView insertWorker(HttpServletRequest request,HttpServletResponse response,@RequestParam("workerName")
		   String workerName,@RequestParam("phoneNumber") String phoneNumber,@RequestParam("department")String department){ 
			   
			   
			   ModelAndView mv=new ModelAndView();
			  
			   worker.setName(workerName);
			   worker.setDepartment(department);
			   worker.setPhonenumber(phoneNumber);
			
			  boolean inserted=adminService.insertWorker(worker);
			  
			
			   if(inserted) {
				   mv.setViewName("redirect:/Admin/workermanagement");
			   }
			   	return mv;
			   
			   
		   }
	 	
	 	
	 	
	 	 @GetMapping("deleteWorker")
		    public ModelAndView deleteWorker(HttpServletRequest request, HttpServletResponse response,@RequestParam("id")String id) {
		        
				 	String email= (String) request.getSession().getAttribute("email");
				 	 ModelAndView mv = new ModelAndView();
					if (email == null) {
						
			            // Handle case where username is not found in session, perhaps redirect to login
						mv.setViewName("redirect:/forwardHomepage");
			            return mv;
			            
			        }
				 worker.setWorkersid(id);
				 
				 boolean deleted=adminService.deleteWorker(worker);
				 
				 if(deleted) {
					 mv.setViewName("redirect:/Admin/workermanagement");
				 }
				 return mv;
				 
		    }
	 	 
	 	 
	 	 
	 	 
	 	 
	 	 
	 	 
	 	 @RequestMapping("reportmanagement")
	 	 public ModelAndView getReport(HttpServletRequest request, HttpServletResponse response) {
	 		String email= (String) request.getSession().getAttribute("email");
		 	 ModelAndView mv = new ModelAndView();
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
	        List<Admin>adminList=adminService.getAdminlist(email);
	        
	        
	        
			 mv.addObject("AdminName", adminList);
			 mv.addObject("TotalIssueList", issueList.stream().count());
			 mv.addObject("CompletedIssueList", issueList.stream().filter(x->x.getStatus().equals("Completed")).count());
			 mv.addObject("PendingIssueList", issueList.stream().filter(x->x.getStatus().equals("In_progress")).count());
			 mv.addObject("NewIssueList", issueList.stream().filter(x->x.getStatus().equals("Raised")).count());
			 mv.addObject("SupervisorCount", supervisorList.stream().count());
			 mv.addObject("Wardencount", wardenList.stream().count());
			 mv.addObject("StudentCount", studentList.stream().count());
			 mv.addObject("WorkersCount", workerList.stream().count());
			 mv.addObject("AssignedIssueList", issueList.stream().filter(x->x.getStatus().equals("Assigned")).count());
			 
			 mv.setViewName("Admin/reportmanagement");
			 
			
			
			
			
			return mv;
	 		 
	 	 }
	 	 
	 	 @RequestMapping("issueraise")
	 	 public ModelAndView issueraise(HttpServletRequest request, HttpServletResponse response) {
	 		String email= (String) request.getSession().getAttribute("email");
		 	 ModelAndView mv = new ModelAndView();
			if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
				mv.setViewName("redirect:/forwardHomepage");
	            return mv;
	            
	        }
			
	        List<Admin>adminList=adminService.getAdminlist(email);
	        mv.addObject("AdminDetails", adminList);
	        
	        
	        List<Issue>issueList=issueService.getIssue();
	        List<Issue>issueRaised=issueList.stream().filter(x->x.getStatus().equals("Raised")).collect(Collectors.toList());
	        mv.addObject("issueRaised", issueRaised);
			 
			 mv.setViewName("Admin/issueraised");
			 
			 
			
			
			
			return mv;
	 		 
	 	 }
	 	 
	 	 @RequestMapping("issueassign")
	 	 public ModelAndView issueassign(HttpServletRequest request, HttpServletResponse response) {
	 		String email= (String) request.getSession().getAttribute("email");
		 	 ModelAndView mv = new ModelAndView();
			if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
				mv.setViewName("redirect:/forwardHomepage");
	            return mv;
	            
	        }
			
	        List<Admin>adminList=adminService.getAdminlist(email);
	        mv.addObject("AdminDetails", adminList);
	        
	        
	        List<Issue>issueList=issueService.getIssue();
	        List<Issue>issueAssigned=issueList.stream().filter(x->x.getStatus().equals("Assigned")).collect(Collectors.toList());
	        mv.addObject("IssueAssigned", issueAssigned);
			 
			 mv.setViewName("Admin/issueassigned");
			 
			 
			
			
			
			return mv;
	 		 
	 	 }
	 	 
	 	 @RequestMapping("inprogress")
	 	 public ModelAndView inprogress(HttpServletRequest request, HttpServletResponse response) {
	 		String email= (String) request.getSession().getAttribute("email");
		 	 ModelAndView mv = new ModelAndView();
			if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
				mv.setViewName("redirect:/forwardHomepage");
	            return mv;
	            
	        }
			
	        List<Admin>adminList=adminService.getAdminlist(email);
	        mv.addObject("AdminDetails", adminList);
	        
	        
	        List<Issue>issueList=issueService.getIssue();
	        List<Issue>issueProgress=issueList.stream().filter(x->x.getStatus().equals("In_progress")).collect(Collectors.toList());
	        mv.addObject("issueProgress", issueProgress);
			 
			 mv.setViewName("Admin/inprogress");
			 
			 
			
			
			
			return mv;
	 		 
	 	 }
	 	 
	 	@RequestMapping("totalissue")
	 	 public ModelAndView totalissue(HttpServletRequest request, HttpServletResponse response) {
	 		String email= (String) request.getSession().getAttribute("email");
		 	 ModelAndView mv = new ModelAndView();
			if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
				mv.setViewName("redirect:/forwardHomepage");
	            return mv;
	            
	        }
			
	        List<Admin>adminList=adminService.getAdminlist(email);
	        mv.addObject("AdminDetails", adminList);
	        
	        
	        List<Issue>issueList=issueService.getIssue();
	       
	        mv.addObject("totalissue", issueList);
			 
			 mv.setViewName("Admin/totalissue");
			 
			 
			
			
			
			return mv;
	 		 
	 	 }
	 	
	 	@RequestMapping("totalwarden")
	 	 public ModelAndView totalwarden(HttpServletRequest request, HttpServletResponse response) {
	 		String email= (String) request.getSession().getAttribute("email");
		 	 ModelAndView mv = new ModelAndView();
			if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
				mv.setViewName("redirect:/forwardHomepage");
	            return mv;
	            
	        }
			
	        List<Admin>adminList=adminService.getAdminlist(email);
	        mv.addObject("AdminDetails", adminList);
	        
	        
	        List<Warden>wardenList=wardenService.getWarden();
	       
	        mv.addObject("wardendetails", wardenList);
			 
			 mv.setViewName("Admin/wardendetails");
			 
			 
			
			
			
			return mv;
	 		 
	 	 }
	 	
	 	@RequestMapping("totalsupervisor")
	 	 public ModelAndView totalsupervisor(HttpServletRequest request, HttpServletResponse response) {
	 		String email= (String) request.getSession().getAttribute("email");
		 	 ModelAndView mv = new ModelAndView();
			if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
				mv.setViewName("redirect:/forwardHomepage");
	            return mv;
	            
	        }
			
	        List<Admin>adminList=adminService.getAdminlist(email);
	        mv.addObject("AdminDetails", adminList);
	        
	        
	        List<Supervisor>supervisorList=supervisorService.getSupervisor();
	       
	        mv.addObject("supervisordetails", supervisorList);
			 
			 mv.setViewName("Admin/supervisordetails");
			 
			 
			
			
			
			return mv;
	 		 
	 	 }
	 	
	 	
	 	@RequestMapping("totalstudent")
	 	 public ModelAndView totalstudent(HttpServletRequest request, HttpServletResponse response) {
	 		String email= (String) request.getSession().getAttribute("email");
		 	 ModelAndView mv = new ModelAndView();
			if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
				mv.setViewName("redirect:/forwardHomepage");
	            return mv;
	            
	        }
			
			
	        List<Student>studentList=studentService.getStudent();
	        mv.addObject("studentdetails", studentList);
	        
	        

			 
			 mv.setViewName("Admin/studentdetails");
			 
			 
			
			
			
			return mv;
	 		 
	 	 }
	 	
	 	
	 	@RequestMapping("totalworker")
	 	 public ModelAndView totalworker(HttpServletRequest request, HttpServletResponse response) {
	 		String email= (String) request.getSession().getAttribute("email");
		 	 ModelAndView mv = new ModelAndView();
			if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
				mv.setViewName("redirect:/forwardHomepage");
	            return mv;
	            
	        }
			
			
	        List<Worker>workerList=workerService.getWorker();
	        
	        mv.addObject("workersDetails", workerList);
	        
	        

			 
			 mv.setViewName("Admin/workers");
			 
			 
			
			
			
			return mv;
	 		 
	 	 }
	 	
	 	
	 	@RequestMapping("completedissue")
	 	 public ModelAndView completedissue(HttpServletRequest request, HttpServletResponse response) {
	 		String email= (String) request.getSession().getAttribute("email");
		 	 ModelAndView mv = new ModelAndView();
			if (email == null) {
				
	            // Handle case where username is not found in session, perhaps redirect to login
				mv.setViewName("redirect:/forwardHomepage");
	            return mv;
	            
	        }
			
	        List<Admin>adminList=adminService.getAdminlist(email);
	        mv.addObject("AdminDetails", adminList);
	        
	        
	        List<Issue>issueList=issueService.getIssue();
	        List<Issue>issueProgress=issueList.stream().filter(x->x.getStatus().equals("Completed")).collect(Collectors.toList());
	        mv.addObject("totalissue", issueProgress);
			 
			 mv.setViewName("Admin/completedissue");
			 
			 
			
			
			
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


