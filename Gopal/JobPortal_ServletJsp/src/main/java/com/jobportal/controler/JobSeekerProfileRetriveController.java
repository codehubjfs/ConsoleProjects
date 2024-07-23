package com.jobportal.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.jobportal.bean.JobSeekers;
import com.jobportal.dao.JobDao;
import com.jobportal.dao.JobsSeekersDao;

/**
 * Servlet implementation class JobSeekerProfileRetriveController
 */
public class JobSeekerProfileRetriveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobSeekerProfileRetriveController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		 String email = request.getParameter("email"); 
		// Get the email parameter from request
//		String email ="arumukam@gmail.com";
		 
		 HttpSession session = request.getSession();
	        JobSeekers seeke = (JobSeekers) session.getAttribute("seeker");
	        String email =seeke.getEmail();
	        System.out.println(email+"retriver");
	        try {
	        	JobsSeekersDao jd = new JobsSeekersDao();
	        	
	            JobSeekers seeker = jd.getJobSeekerByEmail(email);
	            
	            if (seeker != null) {
	            	request.setAttribute("seeker", seeker); // Set seeker object as attribute
			         
		            request.getRequestDispatcher("/views/JobSeekers/MyProfile.jsp").forward(request, response); // Forward to profile JSP

	                // Job seeker found, do something with the retrieved data
	                // For example, forward to a JSP page and set jobSeeker attribute
	               
	                request.getRequestDispatcher("/showJobSeeker.jsp").forward(request, response);
	            } else {
	                // Handle case where job seeker with provided email was not found
	                // For example, show an error message
	                response.getWriter().println("Job seeker with email " + email + " not found.");
	            }
	            
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            // Handle ClassNotFoundException (probably by showing an error page)
	            response.getWriter().println("Error: Class not found exception occurred.");
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
