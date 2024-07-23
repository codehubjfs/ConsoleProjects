package com.jobportal.controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.jobportal.bean.Admin;
import com.jobportal.bean.JobSeekers;
import com.jobportal.dao.AdminDao;
import com.jobportal.dao.JobsSeekersDao;

/**
 * Servlet implementation class SeekerPasswordRestController
 */
public class SeekerPasswordRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeekerPasswordRestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		    // Retrieve form parameters
		   
		   
		    String email = request.getParameter("email");
		    String oldPassword = request.getParameter("oldPassword");
		    String newPassword = request.getParameter("newPassword"); // Correct parameter name

		    // Log to check values received
		   // System.out.println("id: " + idStr);
		  
		   // System.out.println("email: " + email);
		   // System.out.println("oldPassword: " + oldPassword);
		   // System.out.println("newPassword: " + newPassword);

		    // Check if idStr is null or empty
		   
		    // Parse id to integer
		   // int id = 107;
System.out.println(email+" email"+" op"+oldPassword+" np"+newPassword);
		    // Get session and admin object
		   // HttpSession session = request.getSession();
		    //Admin admin = (Admin) session.getAttribute("admin");
		    JobSeekers js = new JobSeekers();
           
		    // Check old password and update admin details
		  
		    	
		       
		        js.setEmail(email);
		        js.setPassword(newPassword);
		        JobsSeekersDao jd = new JobsSeekersDao();
		        try {
					jd.changePassword(email, oldPassword, newPassword);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/JobSeekers/ResetPassword.jsp");
		          dispatcher.forward(request, response);
			
		    // Redirect to profile view
		   System.out.println("welcome");
	}

}
