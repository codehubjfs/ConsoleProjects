package com.issueraisesystem.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.issueraisesystem.beans.AdminDetails;
import com.issueraisesystem.dao.AdminDAO;
import com.issueraisesystem.dao.IssueDAO;
import com.issueraisesystem.dao.StudentDAO;
import com.issueraisesystem.dao.SupervisorDAO;
import com.issueraisesystem.dao.WardenDAO;
import com.issueraisesystem.dao.WorkersDAO;

/**
 * Servlet implementation class AdminReportController
 */
public class AdminReportManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminReportManagementController() {
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
		IssueDAO issueDAO=new IssueDAO();
		AdminDAO adminDao=new AdminDAO();
		WorkersDAO workerDao=new WorkersDAO();
		long wardenCount=0;
        int supervisorCount = 0;
        int studentCount=0;
        int issueCount=0;
        int newIssue=0;
       
        long workersCount=0;
        long totalIssueList=0;
        long completedIssueList=0;
        long pendingIssueList=0;
        long newIssueList=0;
        long assignedIssueList=0;
        
        List<AdminDetails>adminDetails=null;
        try {
			adminDetails=adminDao.getAdminDetails();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
       
        try {
        	
        	//Getting Admin Details
        	
        	
        	
        	totalIssueList=issueDAO.totalIssue().stream().count();
       	 	completedIssueList=issueDAO.totalIssue().stream().filter(x->x.getStatus().equals("Completed")).count();
       	 	pendingIssueList=issueDAO.totalIssue().stream().filter(x->x.getStatus().equals("In_progress")).count();
       	 	newIssueList=issueDAO.totalIssue().stream().filter(x->x.getStatus().equals("Raised")).count();
       	 	assignedIssueList=issueDAO.totalIssue().stream().filter(x->x.getStatus().equals("Assigned")).count();
       	 	supervisorCount = supervisorDAO.getSupervisorCount();
       	 	wardenCount=wardenDAO.getWardenCount();
       	 	studentCount=studentDAO.getStudentCount();
       	 	workersCount=workerDao.getWorkersDetails().stream().count();
            issueCount=issueDAO.getIssueCount();
            
          
         
            
	       } catch (Exception e) {
	           e.getMessage();
	       }
        
        	
        	request.setAttribute("AdminName",adminDetails);
        	request.setAttribute("TotalIssueList",totalIssueList);
        	request.setAttribute("CompletedIssueList",completedIssueList);
        	request.setAttribute("PendingIssueList",pendingIssueList);
        	request.setAttribute("SupervisorCount",supervisorCount);
        	request.setAttribute("Wardencount",wardenCount);
        	request.setAttribute("StudentCount",studentCount);
        	request.setAttribute("WorkersCount",workersCount);
        	request.setAttribute("NewIssueList",newIssueList);
        	request.setAttribute("AssignedIssueList",assignedIssueList);
        	
        	request.getRequestDispatcher("/views/Admin/reportmanagement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
