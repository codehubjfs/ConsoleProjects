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
import com.taskManage.model.TaskAssignModel;
import com.taskManage.model.TaskModel;
import com.taskManage.model.UpdateTaskModel;
import com.taskManage.service.ManagerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
    UpdateTaskModel update;
	
	@Autowired
    PersonalTaskModel personalTask;
	
	@Autowired
	TaskModel task;
	
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
            
            EmployeeModel employee = managerService.getByEmail(email);
            int assigned = managerService.getByEmailAssigned(email);
            int completed = managerService.getByEmailCompleted(email);
            int pending = managerService.getByEmailPending(email);
            int overlayed = managerService.getByEmailOverlayed(email);
            
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
            
            
            List<PersonalTaskModel> personalTasks = managerService.selectPersonalAllTasks(email);
            
            modelAndView.addObject("personalTasks", personalTasks);
            
            modelAndView.setViewName("Manager/dashBoard");
        }
        return modelAndView;
	}
	
	@RequestMapping("/assigned")
	public ModelAndView assigned(HttpSession session, HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView modelAndView = new ModelAndView();
		String email = (String) session.getAttribute("Email");
		
        
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        
        if(email==null) {
        	
        	modelAndView.setViewName("redirect:/home");
        	
        }else{
		
        List<AssignedTaskModel> assignedTasks = managerService.getAssignedTasks(email);
        
        System.out.println("getting in.");

        modelAndView.addObject("assignedTasks", assignedTasks);
        
        modelAndView.setViewName("Manager/assignedtask");
        
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
		
		List<AssignedTaskModel> pendingTasks = managerService.getPendingTasks(email);
		
		System.out.println("getting into pending task");

        modelAndView.addObject("pendingTasks", pendingTasks);
        
        modelAndView.setViewName("Manager/pendingtask");
        
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
		
		
		List<AssignedTaskModel> pendingTasks = managerService.getCompletedTasks(email);
		
		System.out.println("getting into completed task");

        modelAndView.addObject("completedTasks", pendingTasks);
        
        modelAndView.setViewName("Manager/completedtask");
        
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
		
		List<AssignedTaskModel> overlayedTasks = managerService.getOverlayedTasks(email);
		
		System.out.println("getting into completed task");

        modelAndView.addObject("overlayedTasks", overlayedTasks);
        
        modelAndView.setViewName("Manager/taskoverlayed");
        
        }
		
		return modelAndView;
		
	}
	
    @RequestMapping("/editprofile")
    public ModelAndView editprofile(@RequestParam("phonenumber") String phone_number, @RequestParam("city") String city, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView();

        String email = (String) session.getAttribute("Email");

        boolean isUpdated = managerService.updateProfile(email, phone_number, city);

        if (isUpdated) {
            modelAndView.setViewName("redirect:/manager/dashboard");
        } else {
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }
    
    @RequestMapping("/personaltask")
    public ModelAndView persoanlTask(HttpSession session,HttpServletResponse response) {
    	
    	 ModelAndView modelAndView = new ModelAndView();

         String email = (String) session.getAttribute("Email");
         
         response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
         response.setHeader("Pragma", "no-cache");
         response.setHeader("Expires", "0");
         
         if(email==null) {
         	
         	modelAndView.setViewName("redirect:/home");
         	
         }else{         
         
         List<PersonalTaskModel> personalTasks = managerService.getPersonalByEmail(email);
         
         modelAndView.addObject("personalTasks", personalTasks);

         modelAndView.setViewName("Manager/personaltask");
         
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

        managerService.insertPersonalTask(personalTask);
        
        modelAndView.setViewName("redirect:/manager/personaltask");
        
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

        boolean update = managerService.updatePersonalTask(personalTask);
    	
        if (update) {
            modelAndView.setViewName("redirect:/manager/personaltask");
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
    	
    	managerService.deletePersonalTask(email, task_id);
    	
    	modelAndView.setViewName("redirect:/manager/personalTask");
    	
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
        
        
        boolean isUpdated = managerService.updateEmployeeTask(update);

        if (isUpdated) {
            modelAndView.setViewName("redirect:/manager/assigned");
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
        
        
        boolean isUpdated = managerService.updateEmployeeTask(update);

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
        
        
        boolean isUpdated = managerService.updateEmployeeTask(update);

        if (isUpdated) {
            modelAndView.setViewName("redirect:/employee/overlayed");
        } else {
            modelAndView.setViewName("error");
        }

        return modelAndView;
        
    }
    
    @RequestMapping("/taskmanage")
    public ModelAndView taskmanage(HttpSession session,HttpServletResponse response) {
    	
    	String email = (String) session.getAttribute("Email");
    	
    	ModelAndView modelAndView = new ModelAndView();
    	
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        
        if(email==null) {
        	
        	modelAndView.setViewName("redirect:/home");
        	
        }else{
    	
        List<TaskModel> task = managerService.getFutureTasks();
        
        modelAndView.addObject("task", task);
        
        System.out.println("Email" + email);
        
        List<TaskAssignModel> assignTask = managerService.taskAssignAll(email);
        
        modelAndView.addObject("assignTask", assignTask);

        modelAndView.setViewName("Manager/taskmanage");
        
        }
        
		return modelAndView;
    	
    }
    
    @RequestMapping("/taskCreation")
    public ModelAndView taskCreation(HttpSession session, @RequestParam("taskName")String task_name, @RequestParam("desp")String task_desp, @RequestParam("priority")String task_priortiy ,
    		 @RequestParam("startDate")String start_date,@RequestParam("endDate")String end_date) {
    	
    	ModelAndView modelAndView = new ModelAndView();
    	
    	task.setTask_name(task_name);
    	task.setTask_desp(task_desp);
    	task.setTask_priortiy(task_priortiy);
    	task.setStart_date(LocalDate.parse(start_date));
    	task.setEnd_date(LocalDate.parse(end_date));
    	
    	managerService.insertTask(task);
    	
    	modelAndView.setViewName("redirect:/manager/taskmanage");
    	
		return modelAndView;

    }
    
    @RequestMapping("/editTask")
    public ModelAndView editTask(@RequestParam("task_id") int task_id,@RequestParam("taskName") String task_name, @RequestParam("taskDesp") String task_desp, @RequestParam("status") String task_priortiy,
   		 @RequestParam("taskStart") String start_date,  @RequestParam("taskEnd") String end_date,HttpSession session) {
    	
    	ModelAndView modelAndView = new ModelAndView();
    	
    	task.setTask_id(task_id);
    	task.setTask_name(task_name);
    	task.setTask_desp(task_desp);
    	task.setTask_priortiy(task_priortiy);
    	task.setStart_date(LocalDate.parse(start_date));
    	task.setEnd_date(LocalDate.parse(end_date));
    	
    	boolean update = managerService.updateTask(task);
    	
    	if (update) {
            modelAndView.setViewName("redirect:/manager/taskmanage");
        } else {
            modelAndView.setViewName("error");
        }
    	
		return modelAndView;
    	
    }
    
    @RequestMapping("/DeleteTask")
    public ModelAndView deleteTask(HttpSession session, @RequestParam("taskId") int task_id) {
    	
    	ModelAndView modelAndView = new ModelAndView();
    	
    	managerService.deleteTask(task_id);
    	
    	managerService.deleteAssignedTask(task_id);
    	
    	modelAndView.setViewName("redirect:/manager/taskmanage");
    	
		return modelAndView;
    	
    }
    
    @RequestMapping("/DeleteAssign")
    public ModelAndView deleteAssign(HttpSession session,@RequestParam("taskId")int task_id,@RequestParam("empId") int emp_id) {
    	
    	ModelAndView modelAndView = new ModelAndView();
    	
    	managerService.deleteAssignTask(task_id, emp_id);
    	
    	modelAndView.setViewName("redirect:/manager/taskmanage");
    	
		return modelAndView;
    }
    
    @RequestMapping("/calender")
    public ModelAndView calender(HttpSession session,HttpServletResponse response) {
    	
    	ModelAndView modelAndView = new ModelAndView();
    	
    	String email = (String) session.getAttribute("Email");
    	
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        
        if(email==null) {
        	
        	modelAndView.setViewName("redirect:/home");
        	
        }else{    	
		
		modelAndView.setViewName("Manager/calender");
		
        }
		
		return modelAndView;
    }
    
    @RequestMapping("/assignTask")
    public ModelAndView calender(HttpSession session, @RequestParam("taskId") int task_id, @RequestParam("emp_id") int emp_id) {
    	
    	ModelAndView modelAndView = new ModelAndView();
    	
    	
    	int mag_id = (int) session.getAttribute("emp_id");
    	
    	managerService.insertAssignTask(emp_id, task_id, mag_id);
    	
    	modelAndView.setViewName("redirect:/manager/taskmanage");
    	
		return modelAndView;
    	
    }
    
    @RequestMapping("/team")
    public ModelAndView team(HttpSession session,HttpServletResponse response) {
    	
    	
    	ModelAndView modelAndView = new ModelAndView();
    	
    	String email = (String) session.getAttribute("Email");
    	
    	int mag_id = (int) session.getAttribute("emp_id");
    	
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        
        if(email==null) {
        	
        	modelAndView.setViewName("redirect:/home");
        	
        }else{  
        	
            List<EmployeeModel> employees = managerService.selectEmployeeByMage(mag_id);
            
            modelAndView.addObject("employees", employees);
            
            modelAndView.setViewName("Manager/team");
        	
        }
        return modelAndView;
        
    }
    
    @RequestMapping("editAssign")
    public ModelAndView editAssign(HttpSession session, @RequestParam("task_id") int task_id, @RequestParam("emp_id")int emp_id,@RequestParam("status")String status) {	
    	
    	ModelAndView modelAndView = new ModelAndView();
    	
        int status_id=0;
        
        switch(status) {
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
        
        managerService.updateAssign(status_id, emp_id, task_id);
        
    	modelAndView.setViewName("redirect:/manager/taskmanage");
    	
		return modelAndView;
        	
    }
    
}
