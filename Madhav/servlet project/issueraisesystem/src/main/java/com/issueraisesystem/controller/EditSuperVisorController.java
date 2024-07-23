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
 * Servlet implementation class EditSuperVisorController
 */
public class EditSuperVisorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSuperVisorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String mailid=request.getParameter("mailid");
		
		System.out.println(mailid);
		String name=request.getParameter("name");
		String department=request.getParameter("department");
		
		
		System.out.println("1");
		System.out.println(department);
		
		SupervisorDetails supervisor=new SupervisorDetails();
		supervisor.setMailid(mailid);
		supervisor.setName(name);
		supervisor.setDepartment(department);
		
		SupervisorDAO supervisorDao=new SupervisorDAO();
		boolean updated=false;
		
		
		try {
			updated=supervisorDao.updateWorkers(supervisor);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(updated) {
			request.getRequestDispatcher("SuperVisorManagementController").forward(request, response);
		}
		else {
			request.getRequestDispatcher("views/Admin/supervisormanagement.jsp").forward(request, response);
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
