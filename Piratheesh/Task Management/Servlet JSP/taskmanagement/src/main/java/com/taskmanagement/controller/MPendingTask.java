package com.taskmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.taskmanagement.beans.PendingBeans;
import com.taskmanagement.dao.PendingDAO;

/**
 * Servlet implementation class MPendingTask
 */
public class MPendingTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MPendingTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("HII");
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("employeeMail");
		
		System.out.println(email);
		
		PendingDAO assignedDAO = new PendingDAO();
		
		List<PendingBeans> pendingTask = assignedDAO.getPendingTask(email);
		for(PendingBeans c: pendingTask) {
        	System.out.println(c.getTask_id());
        }
		
		request.setAttribute("pendingTasks", pendingTask);
		
		request.getRequestDispatcher("views/Manager/pendingtask.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
