package com.issueraisesystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.issueraisesystem.beans.AdminDetails;
import com.issueraisesystem.beans.Issue;
import com.issueraisesystem.dao.AdminDAO;
import com.issueraisesystem.dao.IssueDAO;
import com.issueraisesystem.dao.StudentDAO;
import com.issueraisesystem.dao.SupervisorDAO;
import com.issueraisesystem.dao.WardenDAO;
import com.issueraisesystem.dao.WorkersDAO;

/**
 * Servlet implementation class AdminDashboardController
 */


public class AdminDashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDashboardController() {
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
		
		SupervisorDAO supervisorDAO = new SupervisorDAO();
		WardenDAO wardenDAO=new WardenDAO();
		StudentDAO studentDAO=new StudentDAO();
		WorkersDAO workerDAO=new WorkersDAO();
		IssueDAO issueDAO=new IssueDAO();
		int wardenCount=0;
        int supervisorCount = 0;
        int studentCount=0;
        int issueCount=0;
        int newIssue=0;
        long workersCount=0;
        long totalIssueList=0;
        long completedIssueList=0;
        long pendingIssueList=0;
        long newIssueList=0;
        
        AdminDAO adminDao=new AdminDAO();
        List<AdminDetails>adminDetails=null;
        try {
        	
        	//Getting Admin Details
        	adminDetails=adminDao.getAdminDetails();     
        	
        	
        	totalIssueList=issueDAO.totalIssue().stream().count();
       	 	completedIssueList=issueDAO.totalIssue().stream().filter(x->x.getStatus().equals("Completed")).count();
       	 	pendingIssueList=issueDAO.totalIssue().stream().filter(x->x.getStatus().equals("In_progress")).count();
       	 	newIssueList=issueDAO.totalIssue().stream().filter(x->x.getStatus().equals("Raised")).count();
       	 	supervisorCount = supervisorDAO.getSupervisorCount();
       	 	wardenCount=wardenDAO.getWardenCount();
       	 	studentCount=studentDAO.getStudentCount();
       	 	workersCount=workerDAO.getWorkersDetails().stream().count();
            issueCount=issueDAO.getIssueCount();
            
            
           
            
	       } catch (Exception e) {
	           e.getMessage();
	       }
        
        	
        	request.setAttribute("AdminDetails",adminDetails);
        	request.setAttribute("TotalIssueList",totalIssueList);
        	request.setAttribute("CompletedIssueList",completedIssueList);
        	request.setAttribute("PendingIssueList",pendingIssueList);
        	request.setAttribute("SupervisorCount",supervisorCount);
        	request.setAttribute("Wardencount",wardenCount);
        	request.setAttribute("StudentCount",studentCount);
        	request.setAttribute("WorkersCount",workersCount);
        	request.setAttribute("NewIssueList",newIssueList);
        	
        	request.getRequestDispatcher("/views/Admin/dashboard.jsp").forward(request, response);
        	
		
        
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
