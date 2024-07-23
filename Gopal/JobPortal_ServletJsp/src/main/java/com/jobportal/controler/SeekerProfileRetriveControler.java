package com.jobportal.controler;

import com.jobportal.bean.Admin;
import com.jobportal.bean.JobSeekers;
import com.jobportal.dao.JobsSeekersDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class SeekerProfileRetriveControler
 */
//@WebServlet("/SeekerProfileRetriveControler")
public class SeekerProfileRetriveControler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Example email for demonstration
        String email = "krishsri5x20@gmai.co";
        HttpSession session = request.getSession();
        JobSeekers admin = (JobSeekers) session.getAttribute("seeker");
      
System.out.println(admin.getEmail()+" "+"gopalalla");
        JobsSeekersDao jobSeekerDAO = new JobsSeekersDao();
      

        
            try {
            	  JobSeekers 	seeker = jobSeekerDAO.retrieveSeeker(email);
				
				if (seeker != null) { request.setAttribute("seeker", seeker); // Set seeker object as attribute
			         
			            request.getRequestDispatcher("/views/JobSeekers/MyProfile.jsp").forward(request, response); // Forward to profile JSP

			        } else {
			            request.setAttribute("error", "Profile not found"); // Set error message attribute
			            request.getRequestDispatcher("/views/JobSeekers/Error.jsp").forward(request, response); // Forward to error JSP
			        }
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Retrieve seeker based on email
       

        
    }
}
