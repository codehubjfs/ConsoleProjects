package com.jobportal.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jobportal.bean.Employer;
import com.jobportal.bean.JobSeekers;
import com.jobportal.bean.Jobs;
import com.jobportal.dao.AdminDao;
import com.jobportal.dao.EmployerDao;
import com.jobportal.dao.JobDao;

/**
 * Servlet implementation class DashBordContentController
 */
public class DashBordContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashBordContentController() {
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
		
		EmployerDao ed = new EmployerDao();
	    // Retrieve list of JobSeekers from AdminDao
		List<Employer> employer =ed.getAllEmployers1();
		System.out.println(employer);
		int employe = employer.size();
		  request.setAttribute("employe", employe);

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
	        request.setAttribute("jobSize", jobSize);
              AdminDao admin = new AdminDao();
		    
		   
		        // Retrieve list of JobSeekers from AdminDao
		        List<JobSeekers> jobSeekersList;
		        int seekerSize = 0;
				try {
					jobSeekersList = admin.JobSeekers();
					seekerSize =jobSeekersList.size();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     System.out.println();
		        // Store the jobSeekersList in request scope to pass to JSP or further processing
		        request.setAttribute("seekerSize", seekerSize);
		        response.sendRedirect("AdminLoginServlet");
	}
}
