package com.jobportal.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import com.jobportal.bean.JobSeekers;
import com.jobportal.dao.JobsSeekersDao;

/**
 * Servlet implementation class SeekerLogin
 */
public class SeekerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeekerLogin() {
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
		String email =req.getParameter("email");
	 String password =req.getParameter("password");
		//System.out.println(email+" "+password);
		JobsSeekersDao jsd = new JobsSeekersDao();
		 HttpSession session = req.getSession();
		
		try {
			JobSeekers seeker = jsd.login(email, password);
		
			if(seeker !=null) {
				
				if(seeker.getGender()!=null) {
				 
				   session.setAttribute("seeker",seeker);

			        
					System.out.print("welcome login");
					// Redirect to admin dashboard
					
					
					res.sendRedirect(req.getContextPath() + "/views/JobSeekers/SeekerDash.jsp");
				}
				else {
					   System.out.print("emailchecke"+email);
				        session.setAttribute("email",email);
					
					res.sendRedirect(req.getContextPath() + "/views/JobSeekers/RegisterProfile.jsp");
				}
				
			}
			else {
				
				System.out.print("check username password");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
