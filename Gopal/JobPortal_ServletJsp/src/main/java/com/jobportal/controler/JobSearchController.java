package com.jobportal.controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jobportal.bean.JobSeekers;
import com.jobportal.bean.Jobs;
import com.jobportal.dao.JobDao;

/**
 * Servlet implementation class JobSearchController
 */
public class JobSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		Jobs js = new Jobs();
		List<Jobs>jobList = new ArrayList<>();
		JobDao jd = new JobDao();
		try {
			jobList = jd.viewAllJobs();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 request.setAttribute("jobList", jobList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/JobSeekers/SearchJob.jsp");
		dispatcher.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
//		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	        int currentPage = 1; // Default page if not specified
//	        int recordsPerPage = 5; // Number of records per page
//
//	        if (request.getParameter("page") != null) {
//	            currentPage = Integer.parseInt(request.getParameter("page"));
//	        }
//
//	        JobDao jobDao = new JobDao();
//
//	        try {
//	            List<Jobs> jobList = jobDao.viewJobsByPage(currentPage, recordsPerPage);
//	            request.setAttribute("jobList", jobList);
//
//	            for(Jobs j :jobList) {
//	            	System.out.println(j);
//	            }
//	            // Forward to JSP for rendering
//	            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/JobSeekers/SearchJob.jsp");
//	            dispatcher.forward(request, response);
//	        } catch (ClassNotFoundException | SQLException e) {
//	            e.printStackTrace(); // Handle or log the exception appropriately
//	            // Optionally forward to an error page
//	        }
//	    }
		
	}
}
