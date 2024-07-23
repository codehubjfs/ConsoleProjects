package com.taskmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import com.taskmanagement.beans.AssignedBeans;
import com.taskmanagement.dao.AssignedDAO;


public class AssignedTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignedTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("employeeMail");
		
		System.out.println(email);
		
		AssignedDAO assignedDAO = new AssignedDAO();
		
		List<AssignedBeans> assignedTask = assignedDAO.getAssignedTask(email);
		
		
		request.setAttribute("assignedTasks", assignedTask);
		
		String role = (String)session.getAttribute("employeeRole");
		
		System.out.println(role);
		
		
			request.getRequestDispatcher("views/Employee/assignedtask.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
