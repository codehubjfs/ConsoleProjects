package com.jobportal.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.jobportal.bean.JobSeekers;
import com.jobportal.bean.User;
import com.jobportal.dao.JobsSeekersDao;

/**
 * Servlet implementation class SeekerRegisterController
 */
@MultipartConfig
public class SeekerRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeekerRegisterController() {
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
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
		
		String name =req.getParameter("name");
		String email =req.getParameter("email");
		String phone =req.getParameter("phone");
		String password =req.getParameter("password");
		
		
		
		
		JobsSeekersDao seeker = new JobsSeekersDao();
		JobSeekers jobseeker = new JobSeekers();
		jobseeker.setName(name);
		jobseeker.setPhone(phone);
		jobseeker.setEmail(email);
		jobseeker.setPassword(password);
	
		try {
			 SendEmail sendEmail = new SendEmail();
		        String code = sendEmail.getRandom(); // Generate random code
		        User user = new User(name, email, code); // Create user object with name, email, and code
		        boolean emailSent = sendEmail.sendEmail(user);
		        
//		        if (emailSent) {
//		            // Store user object in session for verification
//		            HttpSession session = req.getSession();
//		            session.setAttribute("authcode", user);
//
//		            // Redirect to verification page
//		            res.sendRedirect("verify.jsp");
//		        } else {
//		            // Handle email sending failure (optional)
//		            // Example: redirect to an error page
//		            res.sendRedirect("error.jsp");
//		        }
			
			JobSeekers js = seeker.createSeeker(jobseeker);
			
			if(js !=null) {
				System.out.println(js.getName());
			
				// Redirect to admin dashboard
				res.sendRedirect(req.getContextPath() + "/views/JobSeekers/RegisterSuccess.jsp");
			}
			else {
				String errorMessage ="Email id or PhoneNumber alred exiests";
				req.setAttribute("errorMessage", errorMessage);
				req.getRequestDispatcher("/views/JobSeekers/Error.jsp").forward(req, res);
//				res.sendRedirect(req.getContextPath()+"/views/JobSeekers/Error.jsp");
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		    String errorMessage = "An unexpected error occurred. Please try again.";
		    req.setAttribute("errorMessage", errorMessage);
		 
		    req.getRequestDispatcher("/views/JobSeekers/Error.jsp").forward(req, res);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
