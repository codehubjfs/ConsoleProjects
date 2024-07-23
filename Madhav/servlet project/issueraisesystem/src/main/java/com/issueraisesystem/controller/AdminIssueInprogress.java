package com.issueraisesystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.issueraisesystem.beans.AdminDetails;
import com.issueraisesystem.beans.Issue;
import com.issueraisesystem.dao.AdminDAO;
import com.issueraisesystem.dao.IssueDAO;

/**
 * Servlet implementation class AdminIssueInprogress
 */
public class AdminIssueInprogress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminIssueInprogress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mailid= (String) request.getSession().getAttribute("mailid");
		
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
		
		
		try {
			IssueDAO issueDao=new IssueDAO();
			List<Issue>issueProgress=issueDao.totalIssue().stream().filter(x->x.getStatus().equals("In_progress")).collect(Collectors.toList());
			request.setAttribute("AdminDetails",adminDetails);
			request.setAttribute("issueProgress",issueProgress);
			request.getRequestDispatcher("views/Admin/inprogress.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
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
