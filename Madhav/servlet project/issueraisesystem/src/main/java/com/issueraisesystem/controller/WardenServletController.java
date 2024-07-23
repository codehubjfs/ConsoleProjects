package com.issueraisesystem.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.issueraisesystem.beans.Issue;
import com.issueraisesystem.beans.WardenDetails;
import com.issueraisesystem.dao.IssueDAO;
import com.issueraisesystem.dao.WardenDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WardenServletController
 */
public class WardenServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WardenServletController() {
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

			WardenDAO wardenDAO=new WardenDAO();
			try {
				
				
				List<WardenDetails>profile=wardenDAO.profileOverview(mailid);
				
				
				request.setAttribute("ProfileOverview", profile);
				
				
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			try {
				IssueDAO issueDao=new IssueDAO();
				List<Issue>issueRaised=issueDao.totalIssue().stream().filter(x->x.getStatus().equals("Raised")).collect(Collectors.toList());
				
				request.setAttribute("issueRaised",issueRaised);
				request.getRequestDispatcher("views/warden/viewticket.jsp").forward(request, response);
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
