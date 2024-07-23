package com.taskmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.taskmanagement.dao.TaskDao;

/**
 * Servlet implementation class ManagerDashBoard
 */
public class ManagerDashBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerDashBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TaskDao taskdao = new TaskDao();
		HttpSession session = request.getSession();
		String Mail=(String)session.getAttribute("employeeMail");
		
		if(Mail==null) {
			response.sendRedirect("LogoutController");
		}
		
		 if(Mail!=null) {
			 int Acount= 0;
			 int Pcount = 0;
			 int Ccount = 0;
			 int Ocount = 0;
			 try {
				Acount = taskdao.countAssingedTaskEmployee(Mail);
				Pcount = taskdao.countPendingTaskEmployee(Mail);
				Ccount = taskdao.countCompletedTaskEmployee(Mail);
				Ocount = taskdao.countOverlayedTaskEmployee(Mail);
			 }catch(Exception e) {
				 e.getMessage();
			 }
			 request.setAttribute("Assigned", Acount);
			 request.setAttribute("Pending", Pcount);
			 request.setAttribute("Completed", Ccount);
			 request.setAttribute("Overlayed", Ocount);
			 
			 System.out.println(Acount);	
			 System.out.println(Pcount);
			 System.out.println(Ccount);
			 System.out.println(Ocount);
//			 response.sendRedirect("views/Employee/dashBoard.jsp");
			 request.getRequestDispatcher("views/Manager/dashBoard.jsp").forward(request, response);
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
