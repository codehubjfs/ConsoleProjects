package com.jobportal.controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.jobportal.bean.Jobs;
import com.jobportal.dao.JobDao;

/**
 * Servlet implementation class AdminJobView
 */
public class AdminJobView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminJobView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		 JobDao jobDao = new JobDao();
	        List<Jobs> jobsList = null;
	        
	        
				try {
					jobsList = jobDao.viewAllJobs();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 // Set jobs as attribute in request scope
		        request.setAttribute("jobsList", jobsList);
		       
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/AdminLogin.jsp");
		          dispatcher.forward(request, response);
			
	        
	       
	        // Forward to a JSP for displaying the jobs (View)
	        
	    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	}

