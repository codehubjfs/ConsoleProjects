package com.jobportal.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jobportal.bean.JobSeekers;
import com.jobportal.dao.JobsSeekersDao;

/**
 * Servlet implementation class UpdatePassword
 */
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePassword() {
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
		
		 String email = "krishsri5x20@gmai.co";
	        
	        JobsSeekersDao jobSeekerDAO = new JobsSeekersDao();
	        JobSeekers seeker = null;

	        try {
	            seeker = jobSeekerDAO.retrieveSeeker(email); // Retrieve seeker based on email
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }

	        if (seeker != null) {
	            request.setAttribute("seeker", seeker); // Set seeker object as attribute
	         
	            request.getRequestDispatcher("/views/JobSeekers/ResetPassword.jsp").forward(request, response); // Forward to profile JSP

	        } else {
	            request.setAttribute("error", "Profile not found"); // Set error message attribute
	            request.getRequestDispatcher("/views/JobSeekers/Error.jsp").forward(request, response); // Forward to error JSP
	        }
	    }
		
	}

