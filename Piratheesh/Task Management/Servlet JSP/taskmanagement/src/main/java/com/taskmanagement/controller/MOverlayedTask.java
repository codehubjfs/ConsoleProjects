package com.taskmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.taskmanagement.beans.OverlayedBeans;
import com.taskmanagement.dao.OverlayedDAO;

/**
 * Servlet implementation class MOverlayedTask
 */
public class MOverlayedTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MOverlayedTask() {
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
		
		OverlayedDAO overlayedDAO = new OverlayedDAO();
		
		List<OverlayedBeans> overlayedTask = overlayedDAO.getOverlayedTask(email);
		for(OverlayedBeans c: overlayedTask) {
        	System.out.println(c.getTask_id());
        }
		
		request.setAttribute("overlayedTasks", overlayedTask);
		
		request.getRequestDispatcher("views/Manager/taskoverlayed.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
