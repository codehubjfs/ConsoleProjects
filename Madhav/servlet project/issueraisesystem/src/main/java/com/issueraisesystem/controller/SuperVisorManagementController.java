package com.issueraisesystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.issueraisesystem.beans.AdminDetails;
import com.issueraisesystem.beans.SupervisorDetails;
import com.issueraisesystem.beans.WardenDetails;
import com.issueraisesystem.dao.AdminDAO;
import com.issueraisesystem.dao.SupervisorDAO;
import com.issueraisesystem.dao.WardenDAO;

/**
 * Servlet implementation class SuperVisorManagement
 */

@WebServlet("/SuperVisorManagementController")
public class SuperVisorManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuperVisorManagementController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String mailid=(String) request.getSession().getAttribute("mailid");
		if (mailid == null) {
			
            // Handle case where username is not found in session, perhaps redirect to login
			request.getRequestDispatcher("//logout").forward(request, response);
            return;
        }
		 AdminDAO adminDao=new AdminDAO();
		 List<AdminDetails>adminDetails=null;
		try {
        	
			adminDetails=adminDao.getAdminDetails();     
        	
        	
        }
        catch(Exception e) {
        	System.out.println(e.getMessage());
        }
		
		SupervisorDAO supervisorDao=new SupervisorDAO();
		
		try {
			request.setAttribute("AdminDetails",adminDetails);
			List<SupervisorDetails>superDetails=supervisorDao.getAllSupervisor();
			request.setAttribute("supervisorDetails",superDetails);
			request.getRequestDispatcher("views/Admin/supervisormanagement.jsp").forward(request, response);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
