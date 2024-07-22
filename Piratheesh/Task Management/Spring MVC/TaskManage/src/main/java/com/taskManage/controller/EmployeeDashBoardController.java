package com.taskManage.controller;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.taskManage.model.AssignedTaskModel;
import com.taskManage.model.EmployeeModel;
import com.taskManage.model.PersonalTaskModel;
import com.taskManage.model.TaskModel;
import com.taskManage.model.UpdateTaskModel;
import com.taskManage.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/employee")
public class EmployeeDashBoardController {
	
	@Autowired
	private EmployeeService employeeservice;
	
	@Autowired
    UpdateTaskModel update;
	
	@Autowired
    PersonalTaskModel personalTask;
	
    @RequestMapping("/dashboard")
    public ModelAndView dashboard(HttpSession session, HttpServletRequest request,HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        String email = (String) session.getAttribute("Email");
        
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        
        if(email==null) {
        	
        	modelAndView.setViewName("redirect:/home");
        	
        }else{
        
        EmployeeModel employee =employeeservice.getByEmail(email);
        int assigned = employeeservice.getByEmailAssigned(email);
        int completed = employeeservice.getByEmailCompleted(email);
        int pending = employeeservice.getByEmailPending(email);
        int overlayed = employeeservice.getByEmailOverlayed(email);
        
        session.setAttribute("Assigned", assigned);
        session.setAttribute("Completed", completed);
        session.setAttribute("Pending", pending);
        session.setAttribute("Overlayed", overlayed);
        
        System.out.println(employee.getName());
        
        session.setAttribute("emp_id", employee.getEmp_id());
        session.setAttribute("employeeName", employee.getName());
        session.setAttribute("employeeMail", email);
        session.setAttribute("employeeNumber", employee.getPhone_number());
        session.setAttribute("employeeRole", employee.getRole());
        session.setAttribute("employeeCity", employee.getCity());
        
        
        List<PersonalTaskModel> personalTasks = employeeservice.selectPersonalTasks(email);
        
        modelAndView.addObject("personalTasks", personalTasks);
        
        modelAndView.setViewName("Employee/dashBoard");
        }
        return modelAndView;
    }
    
    @RequestMapping("/calender")
    public ModelAndView calender(HttpSession session,HttpServletResponse response) {
    	
    	ModelAndView modelAndView = new ModelAndView();
    	
    	String email=(String) session.getAttribute("Email");
    	
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        
        if(email==null) {
        	
        	modelAndView.setViewName("redirect:/home");
        	
        }else{ 
		
		modelAndView.setViewName("Employee/calender");
		
        }
		
		return modelAndView;
    }
    
	@RequestMapping("/assigned")
	public ModelAndView assigned(HttpSession session,HttpServletResponse response) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		String email = (String) session.getAttribute("Email");
		
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        
        if(email==null) {
        	
        	modelAndView.setViewName("redirect:/home");
        	
        }else{ 
		
        List<AssignedTaskModel> assignedTasks = employeeservice.getAssignedTasks(email);
        
        System.out.println("getting in.");

        modelAndView.addObject("assignedTasks", assignedTasks);
        
        modelAndView.setViewName("Employee/assignedtask");
        
        }
		
		return modelAndView;
		
	}
	
	@RequestMapping("/pending")
	public ModelAndView pending(HttpSession session,HttpServletResponse response) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		String email = (String) session.getAttribute("Email");	
		
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        
        if(email==null) {
        	
        	modelAndView.setViewName("redirect:/home");
        	
        }else{ 
		
		List<AssignedTaskModel> pendingTasks = employeeservice.getPendingTasks(email);
		
		System.out.println("getting into pending task");

        modelAndView.addObject("pendingTasks", pendingTasks);
        
        modelAndView.setViewName("Employee/pendingtask");
        
        }
		
		return modelAndView;
		
	}
	
	@RequestMapping("/completed")
	public ModelAndView completed(HttpSession session,HttpServletResponse response) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		String email = (String) session.getAttribute("Email");	
		
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        
        if(email==null) {
        	
        	modelAndView.setViewName("redirect:/home");
        	
        }else{ 
		
		List<AssignedTaskModel> pendingTasks = employeeservice.getCompletedTasks(email);
		
		System.out.println("getting into completed task");

        modelAndView.addObject("completedTasks", pendingTasks);
        
        modelAndView.setViewName("Employee/completedtask");
        
        }
		
		return modelAndView;
		
	}
	
	@RequestMapping("/overlayed")
	public ModelAndView overlayed(HttpSession session,HttpServletResponse response) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		String email = (String) session.getAttribute("Email");
		
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        
        if(email==null) {
        	
        	modelAndView.setViewName("redirect:/home");
        	
        }else{ 
		
		List<AssignedTaskModel> overlayedTasks = employeeservice.getOverlayedTasks(email);
		
		System.out.println("getting into completed task");

        modelAndView.addObject("overlayedTasks", overlayedTasks);
        
        modelAndView.setViewName("Employee/overlayed");
        
        }
		
		return modelAndView;
		
	}
	
    @RequestMapping("/editprofile")
    public ModelAndView editprofile(@RequestParam("phonenumber") String phone_number, @RequestParam("city") String city, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView();

        String email = (String) session.getAttribute("Email");

        boolean isUpdated = employeeservice.updateProfile(email, phone_number, city);

        if (isUpdated) {
            modelAndView.setViewName("redirect:/employee/dashboard");
        } else {
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }
    
    @RequestMapping("/personalTask")
    public ModelAndView persoanlTask(HttpSession session,HttpServletResponse response) {
    	
    	 ModelAndView modelAndView = new ModelAndView();

         String email = (String) session.getAttribute("Email");
         
         response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
         response.setHeader("Pragma", "no-cache");
         response.setHeader("Expires", "0");
         
         if(email==null) {
         	
         	modelAndView.setViewName("redirect:/home");
         	
         }else{ 
         
         List<PersonalTaskModel> personalTasks = employeeservice.getPersonalByEmail(email);
         
         modelAndView.addObject("personalTasks", personalTasks);
         
         List<TaskModel> task = employeeservice.selectTaskName(email);
         
         modelAndView.addObject("task",task);
         
         System.out.println(task);

         modelAndView.setViewName("Employee/personaltask");
         
         }
         
         return modelAndView;
    	
    }
    
    @RequestMapping("/personalTaskAdd")
    public ModelAndView persoanlTaskAdd(@RequestParam("taskName") String task_name, @RequestParam("desp") String task_desp, @RequestParam("priority") String task_priority,
    		 @RequestParam("startDate") String startDate,  @RequestParam("endDate") String endDate, HttpSession session) {
  
    	
   	    ModelAndView modelAndView = new ModelAndView();

        String email = (String) session.getAttribute("Email");
        
        personalTask.setTask_name(task_name);
        personalTask.setTask_desp(task_desp);
        personalTask.setTask_priority(task_priority);
        personalTask.setStart_date(LocalDate.parse(startDate));
        personalTask.setEnd_date(LocalDate.parse(endDate));
        personalTask.setEmail(email);

        employeeservice.insertPersonalTask(personalTask);
        
        modelAndView.setViewName("redirect:/employee/personalTask");
        
		return modelAndView;
    	
    }
    
    @RequestMapping("/personalTaskEdit")
    public ModelAndView persoanlTaskEdit(@RequestParam("editTaskId") int task_id,@RequestParam("editTaskName") String task_name, @RequestParam("editTaskDescription") String task_desp, @RequestParam("editTaskPriority") String task_priority,
    		 @RequestParam("editStartDate") String start_date,  @RequestParam("editEndDate") String end_date, HttpSession session) {
    	
   	    ModelAndView modelAndView = new ModelAndView();

        String email = (String) session.getAttribute("Email");
        
        
        personalTask.setTask_id(task_id);
        personalTask.setTask_name(task_name);
        personalTask.setTask_desp(task_desp);
        personalTask.setTask_priority(task_priority);
        personalTask.setStart_date(LocalDate.parse(start_date));
        personalTask.setEnd_date(LocalDate.parse(end_date));
        personalTask.setEmail(email);

        boolean update = employeeservice.updatePersonalTask(personalTask);
    	
        if (update) {
            modelAndView.setViewName("redirect:/employee/personalTask");
        } else {
            modelAndView.setViewName("error");
        }
        
		return modelAndView;
    	
    }
    
    @RequestMapping("/deletePersonalTask")
    public ModelAndView deletePersonalTask(@RequestParam("taskId")int task_id, HttpSession session) {
    	
    	ModelAndView modelAndView = new ModelAndView();
    	System.out.println(task_id);
    	String email = (String) session.getAttribute("Email");
    	
    	employeeservice.deletePersonalTask(email, task_id);
    	
    	modelAndView.setViewName("redirect:/employee/personalTask");
    	
		return modelAndView;
    }
    
    @RequestMapping("/updateassignedtask")
    public ModelAndView updateassignedtask(@RequestParam("task_id") int task_id, @RequestParam("status") String task_status, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView();

        int emp_id = (int) session.getAttribute("emp_id");
        
        int status_id=0;
        
        switch(task_status) {
		case "assigned":
			status_id=1;
			break;
			
		case "pending":
			status_id=3;
			break;
			
		case "completed":
			status_id=4;
			break;
			
		case "overlayed":
			status_id=5;
			break;
			
		}
        
        update.setEmp_id(emp_id);
        update.setTask_id(task_id);
        update.setTask_status(status_id);
        
        
        boolean isUpdated = employeeservice.updateEmployeeTask(update);

        if (isUpdated) {
            modelAndView.setViewName("redirect:/employee/assigned");
        } else {
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }
    
    @RequestMapping("/updatependingtask")
    public ModelAndView updatependingtask(@RequestParam("task_id") int task_id, @RequestParam("status") String task_status, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView();

        int emp_id = (int) session.getAttribute("emp_id");
        
        int status_id=0;
        
        switch(task_status) {
		case "assigned":
			status_id=1;
			break;
			
		case "pending":
			status_id=3;
			break;
			
		case "completed":
			status_id=4;
			break;
			
		case "overlayed":
			status_id=5;
			break;
			
		}
        
        update.setEmp_id(emp_id);
        update.setTask_id(task_id);
        update.setTask_status(status_id);
        
        
        boolean isUpdated = employeeservice.updateEmployeeTask(update);

        if (isUpdated) {
            modelAndView.setViewName("redirect:/employee/pending");
        } else {
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }
    
    @RequestMapping("/updateoverlayedtask")
    public ModelAndView updateoverlayedtask(@RequestParam("task_id") int task_id, @RequestParam("status") String task_status, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView();

        int emp_id = (int) session.getAttribute("emp_id");
        
        int status_id=0;
        
        switch(task_status) {
		case "assigned":
			status_id=1;
			break;
			
		case "pending":
			status_id=3;
			break;
			
		case "completed":
			status_id=4;
			break;
			
		case "overlayed":
			status_id=5;
			break;
			
		}
        
        update.setEmp_id(emp_id);
        update.setTask_id(task_id);
        update.setTask_status(status_id);
        
        
        boolean isUpdated = employeeservice.updateEmployeeTask(update);

        if (isUpdated) {
            modelAndView.setViewName("redirect:/employee/overlayed");
        } else {
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }


}
