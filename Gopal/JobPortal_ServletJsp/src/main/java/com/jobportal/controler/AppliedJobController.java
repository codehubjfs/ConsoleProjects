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
import java.util.ArrayList;
import java.util.List;

import com.jobportal.bean.JobSeekers;
import com.jobportal.bean.Jobs;
import com.jobportal.dao.JobDao;

/**
 * Servlet implementation class AppliedJobController
 */
public class AppliedJobController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppliedJobController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		// This should be dynamically fetched based on the logged-in user.
		 
		 HttpSession session = request.getSession();
	        JobSeekers seeker = (JobSeekers) session.getAttribute("seeker");
//	       System.out.println+"your seeker_id");
	       int jobSeekerId =seeker.getSeeker_id();
	        List<Jobs> jobList = new ArrayList<>();
	        JobDao jobDao = new JobDao();
	        
	       
	            try {
					jobList = jobDao.viewApplicationStatus(jobSeekerId);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	       
	        
	        request.setAttribute("jobsList", jobList);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("views/JobSeekers/AppliedJob.jsp");
	        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
