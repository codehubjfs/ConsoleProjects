package com.issueraisesystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.issueraisesystem.beans.Issue;
import com.issueraisesystem.beans.StudentDetails;
import com.issueraisesystem.dao.*;

/**
 * Servlet implementation class SupervisorController
 */
@WebServlet("/Sdashboard")
public class StudentDashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */	
    public StudentDashboardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		SupervisorDAO supervisorDAO = new SupervisorDAO();
		WardenDAO wardenDAO=new WardenDAO();
		StudentDAO studentDAO=new StudentDAO();
		IssueDAO issueDAO=new IssueDAO();
		int wardenCount=0;
        int supervisorCount = 0;
        int studentCount=0;
        int issueCount=0;
        int issueOpened=0;
        int issueProgress=0;
        int issueCompleted=0;
        
        String mailid=(String) request.getSession().getAttribute("mailid");
        
        if (mailid == null) {
			
            // Handle case where username is not found in session, perhaps redirect to login
			request.getRequestDispatcher("//logout").forward(request, response);
            return;
        }
        try {
        	
        	 wardenCount=wardenDAO.getWardenCount();
             supervisorCount = supervisorDAO.getSupervisorCount();
             studentCount=studentDAO.getStudentCount();
             issueCount=issueDAO.getIssueCount();
             issueOpened=issueDAO.getIssueOpened(mailid);
             issueProgress=issueDAO.getIssueProgress(mailid);
             issueCompleted=issueDAO.getIssueCompleted(mailid);
             
        } catch (Exception e) {
            e.getMessage();
        }
        
        
        
       
       
        //Recent Ticket by user
        try {
			List<Issue> tickets = new IssueDAO().getRecentTicketsByUsername(mailid);
			
			request.setAttribute("RecentTickets", tickets);

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        
        
        try {
        	
        	StudentDAO student=new StudentDAO();
        	List<StudentDetails>profile=student.profileOverview(mailid);
        	request.setAttribute("ProfileOverview", profile);
        	
        	
        }
        catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        
   
        
        
        request.setAttribute("supervisorCount", supervisorCount);
        request.setAttribute("wardenCount", wardenCount);
        request.setAttribute("studentCount", studentCount);
        request.setAttribute("issueCount",issueCount);
        request.setAttribute("issueOpened",  issueOpened);
        request.setAttribute("issueProgress",  issueProgress);
        request.setAttribute("issueCompleted", issueCompleted);
        
        request.getRequestDispatcher("/views/Student/dashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
