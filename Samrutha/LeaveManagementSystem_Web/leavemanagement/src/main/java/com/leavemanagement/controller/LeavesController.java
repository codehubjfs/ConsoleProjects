package com.leavemanagement.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leavemanagement.model.ApplicationStatus;
import com.leavemanagement.model.Employee;
import com.leavemanagement.model.LeaveType;
import com.leavemanagement.model.Leaves;
import com.leavemanagement.service.LeaveService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/leaves")
public class LeavesController {

	@Autowired
	LeaveService leaveService;
	
	@RequestMapping("/applyLeave")
	public ModelAndView getApplicationDetail(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		Employee emp = (Employee) session.getAttribute("employee");
        if (emp != null) {
        	
    		String leaveType = request.getParameter("leavetype");
            String startdate = request.getParameter("startdate");
            String enddate = request.getParameter("enddate");
            String reason = request.getParameter("leaveReason");
            String suggestEmp = request.getParameter("suggestEmp");
            
            Leaves leave = new Leaves();
            leave.setEmp(emp);
            leave.setLeaveType(LeaveType.valueOf(leaveType));
            LocalDate sdate = LocalDate.parse(startdate);
            leave.setStartDate(sdate);
            LocalDate edate = LocalDate.parse(enddate);
            leave.setEndDate(edate);
            leave.setReason(reason);
            leave.setAssignWork(suggestEmp);
            leave.setStatus(ApplicationStatus.PENDING);
            leave.setRejectionreason("");
            System.out.println(leave);
            leaveService.insertLeave(leave);
            mv.setViewName("redirect:/employee/eleave");
        }
		return mv;
	}
	
	@RequestMapping("/editLeave")
	public ModelAndView getEditDetail(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String username = (String)session.getAttribute("username");
        if (session != null && username!=null) {
            Employee emp = (Employee) session.getAttribute("employee");
            if (emp != null) {
            	String leaveId = request.getParameter("leaveId");
            	System.out.println(leaveId);
                String leaveType = request.getParameter("leaveType");
                System.out.println(leaveType + " = Leave Type at controller");
                
                LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
                LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
                String reason = request.getParameter("reason");
                String assignWork = request.getParameter("assignWork");
                
               
                // Create a new Leaves object with the updated data
                Leaves leave = new Leaves();
                leave.setLeaveId(Integer.parseInt(leaveId));
                leave.setLeaveType(LeaveType.valueOf(leaveType));
                leave.setStartDate(startDate);
                leave.setEndDate(endDate);
                leave.setReason(reason);
                leave.setAssignWork(assignWork);

                // Update the leave in the database
                leaveService.updateLeave(leave);
                mv.setViewName("redirect:/employee/eleave");
            } 
        }
	
		return mv;
	}
	
	
	@RequestMapping("/cancelLeave")
	public ModelAndView cancelLeave(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String username = (String)request.getSession().getAttribute("username");
		Employee emp = (Employee) request.getSession().getAttribute("employee");
		if (emp != null) {
            String leaveId = request.getParameter("leaveId");
            try {
				leaveService.cancelLeave(Integer.parseInt(leaveId));
				
			 } catch (Exception e) {
				
				e.printStackTrace();
			 }
        }
		mv.setViewName("redirect:/employee/eleave");
		return mv;
	}
	
	
	@RequestMapping("/rejectLeave")
	public ModelAndView rejectLeave(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String username = (String)request.getSession().getAttribute("username");
		Employee emp = (Employee) request.getSession().getAttribute("employee");
		if (emp != null) {
            String leaveId = request.getParameter("leaveId");
			String reason = request.getParameter("rejectionReason");

            try {
            	
				leaveService.rejectLeave(Integer.parseInt(leaveId), reason);
				
				
			 } catch (Exception e) {
				
				e.printStackTrace();
			 }
        }
		mv.setViewName("redirect:/manager/mLeaveManagement");
		return mv;
	}
	
	
	@RequestMapping("/approveLeave")
	public ModelAndView approveLeave(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String username = (String)request.getSession().getAttribute("username");
		Employee emp = (Employee) request.getSession().getAttribute("employee");
		if (emp != null) {
            String leaveId = request.getParameter("leaveId");
			String reason = request.getParameter("rejectionReason");
			
			List<Leaves> leaves = leaveService.getLeavesByManagerId(emp.getEmpID());
	        request.setAttribute("leaves", leaves);
	        
			 Leaves leave = leaves.stream().filter(l -> l.getLeaveId() == Integer.parseInt(leaveId))
                     .findFirst()
                     .orElse(null);
			
            try {
            	
				int days = (int)ChronoUnit.DAYS.between(leave.getStartDate(), leave.getEndDate())+1;
				LeaveType leaveType = leave.getLeaveType();
				
				leaveService.updateLeaveCount(leave.getEmp().getEmpID(), days , leaveType);
				leaveService.approveLeave(Integer.parseInt(leaveId), leave.getEmp().getEmpID());
				
			 } catch (Exception e) {
				
				e.printStackTrace();
			 }
        }
		mv.setViewName("redirect:/manager/mLeaveManagement");
		return mv;
	}
	
	
	@RequestMapping("/reassignApproveLeave")
	public ModelAndView reassignApproveLeave(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String username = (String)request.getSession().getAttribute("username");
		Employee emp = (Employee) request.getSession().getAttribute("employee");
		if (emp != null) {
            String leaveId = request.getParameter("leaveId");
            String reassignWork = request.getParameter("reassignWork");
			
			List<Leaves> leaves = leaveService.getLeavesByManagerId(emp.getEmpID());
	        request.setAttribute("leaves", leaves);
	        
			 Leaves leave = leaves.stream().filter(l -> l.getLeaveId() == Integer.parseInt(leaveId))
                     .findFirst()
                     .orElse(null);
			
            try {
            	
				int days = (int)ChronoUnit.DAYS.between(leave.getStartDate(), leave.getEndDate())+1;
				LeaveType leaveType = leave.getLeaveType();
				
				leaveService.updateLeaveCount(leave.getEmp().getEmpID(), days , leaveType);
				leaveService.reassignApproveLeave(Integer.parseInt(leaveId), reassignWork);
				
			 } catch (Exception e) {
				
				e.printStackTrace();
			 }
        }
		mv.setViewName("redirect:/manager/mLeaveManagement");
		return mv;
	}
}
