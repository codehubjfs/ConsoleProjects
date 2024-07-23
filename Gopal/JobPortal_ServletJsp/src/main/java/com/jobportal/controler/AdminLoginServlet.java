package com.jobportal.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jobportal.bean.Admin;
import com.jobportal.bean.Employer;
import com.jobportal.bean.JobSeekers;
import com.jobportal.bean.Jobs;
import com.jobportal.dao.AdminDao;
import com.jobportal.dao.EmployerDao;
import com.jobportal.dao.JobDao;

/**
 * Servlet implementation class LoginServlet
 */

public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Get email and password from the request parameters
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    
	    // Print for debugging (optional)
	    System.out.println("Email: " + email + ", Password: " + password);
	    
	    // Create an instance of AdminDao to interact with the database or service layer
	    AdminDao adminDao = new AdminDao();
	    
	    try {
	        // Attempt to login using the AdminDao
	        Admin admin = adminDao.login(email, password);
	        
	        if (admin != null) {
	            // If login successful, store admin object in session
	            HttpSession session = request.getSession();
	            session.setAttribute("admin", admin);
	            
	            // Redirect to admin dashboard
	            //


	    		EmployerDao ed = new EmployerDao();
	    	    // Retrieve list of JobSeekers from AdminDao
	    		List<Employer> employer =ed.getAllEmployers1();
	    		System.out.println(employer);
	    		int employe = employer.size();
	    		 JobDao jobDao = new JobDao();
	    		 int jobSize = 0;
	    	        List<Jobs> jobsList = new ArrayList<>();
	    	        try {
	    				jobsList = jobDao.viewAllJobs();
	    				jobSize =jobsList.size();
	    			} catch (ClassNotFoundException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			} catch (SQLException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	    	        AdminDao admin1 = new AdminDao();
	    	        List<JobSeekers> jobSeekersList;
			        int seekerSize = 0;
					try {
						jobSeekersList = admin1.JobSeekers();
						seekerSize =jobSeekersList.size();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    	        System.out.println(jobSize+" "+employe);
	    	      session.setAttribute("jobSize", jobSize);
	    		 session.setAttribute("employe", employe);
	    		 session.setAttribute("seekerSize", seekerSize);
	    		
//	    		  request.setAttribute("employe", employe);System.out.println(employe+"jsdjshdshdshdshjdjhsdss");
	            //
	            response.sendRedirect(request.getContextPath() + "/views/Admin/admin.jsp");
	        } else {
	            // If login failed (invalid credentials), forward to login page with error message
	            request.setAttribute("errorMessage", "Invalid email or password");
	            request.getRequestDispatcher("/views/Admin/AdminLogin.jsp").forward(request, response);
	        }
	    } catch (Exception e) {
	        // Handle exceptions (database errors, etc.)
	        e.printStackTrace(); // Print stack trace for debugging (optional)
	        request.setAttribute("errorMessage", "An error occurred. Please try again later.");
	        request.getRequestDispatcher("/views/Admin/AdminLogin.jsp").forward(request, response);
	       
	        
	    }
	}


}
