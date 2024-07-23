package com.issueraisesystem.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.issueraisesystem.dao.IssueDAO;
import com.issueraisesystem.dao.SupervisorDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AssignSupervisorController
 */
public class AssignSupervisorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AssignSupervisorController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mailid=(String) request.getSession().getAttribute("mailid");
        System.out.println("ASsign");
        if (mailid == null) {
			
            // Handle case where username is not found in session, perhaps redirect to login
			request.getRequestDispatcher("//logout").forward(request, response);
            return;
        }
        
        
        
        SupervisorDAO supervisor=new SupervisorDAO();
        
        int supervisorID=Integer.parseInt(request.getParameter("supervisorId"));
        int issueid=Integer.parseInt(request.getParameter("issueId"));
       
        System.out.println(supervisorID);
        System.out.println(issueid);
        
        String supervisorName=null;
        try {
			 supervisorName=supervisor.chooseSupervisor(supervisorID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        try {
			boolean asssign=supervisor.assignSupervisor(supervisorName	,issueid);
			
			request.getRequestDispatcher("ManageTicketController").forward(request, response);
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
