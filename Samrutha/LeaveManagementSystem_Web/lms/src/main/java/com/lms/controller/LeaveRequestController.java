package com.lms.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.lms.bean.Employee;
import com.lms.bean.Leaves;
import com.lms.dao.LeavesDao;

/**
 * Servlet implementation class LeaveRequestController
 */
@WebServlet("/requestLeave")
public class LeaveRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveRequestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = (String)request.getSession().getAttribute("username");
		Employee emp = (Employee) request.getSession().getAttribute("employee");
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		
        if (username==null) {
        	response.sendRedirect("Logout"); 
        } 
	    if (emp != null) {
	    	List<Leaves> leaves = LeavesDao.selectLeaveRequest(emp);
	        request.setAttribute("leaves", leaves);
	        request.getRequestDispatcher("views/Manager/LeaveManagement.jsp").forward(request, response);
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
