package com.jobportal.controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class JobsController
 */


import com.jobportal.bean.Jobs;
import com.jobportal.dao.JobDao;

/**
 * Servlet implementation class AdminJobView
 */
public class JobsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		 JobDao jobDao = new JobDao();
	        List<Jobs> jobsList = new ArrayList<>();
	        
	        
				try {
					jobsList = jobDao.viewAllJobs();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(Jobs j:jobsList) {
					
					System.out.println(j);
				}
				 // Set jobs as attribute in request scope
		        request.setAttribute("jobsList", jobsList);
		       
				 RequestDispatcher dispatcher = request.getRequestDispatcher("views/Admin/JobSmangementForAdmin.jsp");
		          dispatcher.forward(request, response);
			
	        
	       
	        // Forward to a JSP for displaying the jobs (View)
	        
	    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	}




