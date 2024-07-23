package com.issueraisesystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.issueraisesystem.beans.SupervisorDetails;
import com.issueraisesystem.dao.SupervisorDAO;

/**
 * Servlet implementation class AddSupervisorController
 */
public class AddSupervisorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSupervisorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email= (String) request.getSession().getAttribute("mailid");
		
		if (email == null) {
			
            // Handle case where username is not found in session, perhaps redirect to login
			request.getRequestDispatcher("//logout").forward(request, response);
            return;
        }
		
		
		String name=request.getParameter("supervisorName");
		String department=request.getParameter("department");
		String mailid=request.getParameter("mailid");
		String password=request.getParameter("password");
		
		SupervisorDetails supervisor=new SupervisorDetails();
		supervisor.setName(name);
		supervisor.setDepartment("department");
		supervisor.setMailid(mailid);
		supervisor.setPassword(password);
		
		SupervisorDAO supervisorDao=new SupervisorDAO();
		boolean supervisorAdded=false;
		try {
			 supervisorAdded=supervisorDao.addSupervisor(supervisor);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(supervisorAdded) {
			request.getRequestDispatcher("SuperVisorManagementController").forward(request, response);
			
		}
		
		else {
			response.sendRedirect("views/Admin/supervisormanagement.jsp");
		}
		
		
		
		
	}

}
