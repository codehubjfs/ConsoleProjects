package com.jobportal.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.io.OutputStream;
import com.jobportal.dao.JobsSeekersDao;

/**
 * Servlet implementation class ResumeDownload
 */
public class ResumeDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResumeDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		

	        String email = request.getParameter("email");

	        JobsSeekersDao jobSeekersDao = new JobsSeekersDao();
	        byte[] resume = null;
	        try {
	            try {
					resume = jobSeekersDao.getResumeByEmail(email);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        if (resume != null) {
	            response.setContentType("application/pdf");
	            response.setHeader("Content-Disposition", "attachment;filename=resume.pdf");

	            OutputStream os = response.getOutputStream();
	            os.write(resume);
	            os.flush();
	            os.close();
	        } else {
	            response.getWriter().write("No resume found for the given email.");
	        }
	    }
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	


}
