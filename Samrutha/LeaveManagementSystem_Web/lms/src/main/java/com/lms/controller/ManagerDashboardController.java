package com.lms.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.lms.bean.ApplicationStatus;
import com.lms.bean.Employee;
import com.lms.bean.Leaves;
import com.lms.dao.EmployeeDao;
import com.lms.dao.LeavesDao;

/**
 * Servlet implementation class ManagerDashboardController
 */
@WebServlet("/mdashboard")
public class ManagerDashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerDashboardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = (String)request.getSession().getAttribute("username");
		Employee emp = (Employee) request.getSession().getAttribute("employee");
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		
        if (username==null) {
        	response.sendRedirect("Logout");
            
        } 
        
		if(emp!=null) {
			//Team Count
			List<Employee> team = EmployeeDao.selectTeam(emp);
			request.setAttribute("teamCount", team.size());
			
			
			//LeaveCount
			List<Leaves> leaves = LeavesDao.selectLeaveRequest(emp);
	        request.setAttribute("leaves", leaves);
	        request.setAttribute("leaveRequestCount", leaves.stream().filter((l)->l.getStatus()==ApplicationStatus.PENDING).count());
	        
	        
	        //Todays absent
	        request.setAttribute("absent", 
	        	    leaves.stream()
	        	          .filter((l) -> (l.getStatus() == ApplicationStatus.APPROVED) &&
	        	                         (LocalDate.now().isAfter(l.getStartDate()) || LocalDate.now().isEqual(l.getStartDate())) &&
	        	                         (LocalDate.now().isBefore(l.getEndDate()) || LocalDate.now().isEqual(l.getEndDate())))
	        	          .count());
	        
	        //Display name and role
	        
	        
	        //Get all Employees
	        List<Employee> teams = EmployeeDao.selectTeam(emp);
        	request.setAttribute("teams", teams);
        	for(Employee empl: teams) {
        		System.out.println(empl);
        	}
	        request.getRequestDispatcher("views/Manager/index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
