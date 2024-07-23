package com.issueraisesystem.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.issueraisesystem.beans.Issue;
import com.issueraisesystem.beans.StudentDetails;
import com.issueraisesystem.dao.IssueDAO;
import com.issueraisesystem.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TotalIssueController
 */


public class TotalIssueController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TotalIssueController() {
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
		
		try {
        	
        	StudentDAO student=new StudentDAO();
        	List<StudentDetails>profile=student.profileOverview(mailid);
        	request.setAttribute("ProfileOverview", profile);
        	
        	
        }
        catch(Exception e) {
        	System.out.println(e.getMessage());
        }
		
		try {
			IssueDAO issueDao=new IssueDAO();
			List<Issue>totalIssue=issueDao.totalIssue();
			request.setAttribute("totalissue",totalIssue );
			request.getRequestDispatcher("/views/Student/issuecompleted.jsp").forward(request, response);
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
