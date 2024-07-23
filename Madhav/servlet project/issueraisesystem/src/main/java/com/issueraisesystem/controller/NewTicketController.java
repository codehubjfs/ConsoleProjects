package com.issueraisesystem.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.issueraisesystem.beans.Issue;
import com.issueraisesystem.beans.StudentDetails;
import com.issueraisesystem.dao.IssueDAO;
import com.issueraisesystem.dao.StudentDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/**
 * Servlet implementation class NewTicketController
 */


public class NewTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NewTicketController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String mailid= (String) request.getSession().getAttribute("mailid");
		
		if (mailid == null) {
			
            // Handle case where username is not found in session, perhaps redirect to login
			request.getRequestDispatcher("//logout").forward(request, response);
            return;
        }
		
		
		 String issueTitle = request.getParameter("issuetitle");
	        String description = request.getParameter("description");
	        String priority = request.getParameter("priority");
	         Date issueDate = Date.valueOf(request.getParameter("issuedate"));

	        List<String> errors = new ArrayList<>();

	        if (issueTitle == null || issueTitle.isEmpty()) {
	            errors.add("Issue title is required.");
	        }
	        if (description == null || description.isEmpty()) {
	            errors.add("Description is required.");
	        }
	        if (priority == null || priority.isEmpty()) {
	            errors.add("Priority is required.");
	        }
	        if (issueDate == null ) {
	            errors.add("Issue date is required.");
	        }
	        
	        
	       
            
            
	        if (!errors.isEmpty()) {
	            request.setAttribute("errors", errors);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Student/ticketraise.jsp");
	            dispatcher.forward(request, response);
	        } else {
	            // Proceed with ticket creation logic
	            // Redirect or forward to success page
	        
		
				 	String desription=request.getParameter("description");
			        String raisedBy= (String) request.getSession().getAttribute("mailid");
			        Date ticketRaiseDate=Date.valueOf(LocalDate.now());
			        String allocateTo = "NotAllocated";
			        
			       
			        String status ="Raised";
			        Issue issue=new Issue();
			        issue.setIssuetitle(issueTitle);
			        issue.setDescription(desription);
			        issue.setTicketraisedate(ticketRaiseDate);
			        issue.setRaisedby(raisedBy);
			        issue.setAllocateto(allocateTo);
			        issue.setPriority(priority);
			        issue.setStatus(status);
			        issue.setIssuedate(issueDate);
			       
			        IssueDAO issueDAO=new IssueDAO();
			        try {
						issueDAO.addIssue(issue);
						 RequestDispatcher dispatcher = request.getRequestDispatcher("/tickeraise");
					        dispatcher.forward(request, response);	
						request.getRequestDispatcher("views/Student/ticketraise.jsp").forward(request, response);
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
	        }
        
        
        
        
	}

}
