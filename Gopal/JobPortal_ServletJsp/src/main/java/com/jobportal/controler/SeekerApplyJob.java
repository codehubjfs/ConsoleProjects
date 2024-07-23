package com.jobportal.controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jobportal.bean.JobSeekers;
import com.jobportal.dao.JobDao;

/**
 * Servlet implementation class SeekerApplyJob
 */
public class SeekerApplyJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeekerApplyJob() {
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
		
		int job_id =Integer.parseInt(request.getParameter("job_id"));
		int job_seeker =Integer.parseInt(request.getParameter("seeker_id"));
		System.out.println(job_id+" "+job_seeker   +"cross chodkdkdkd ");
		JobSeekers js = new JobSeekers();
		JobDao jd = new JobDao();
		js.setSeeker_id(job_seeker);
		try {
			
			
			jd.applyForJob(job_id,js);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("JobSearchController");
		
	}
      
}
