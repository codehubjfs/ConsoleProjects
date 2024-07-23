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

import com.jobportal.bean.JobSeekers;
import com.jobportal.dao.AdminDao;

/**
 * Servlet implementation class AdminRetriveData
 */
public class AdminRetriveData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRetriveData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		    
		    AdminDao admin = new AdminDao();
		    
		    try {
		        // Retrieve list of JobSeekers from AdminDao
		        List<JobSeekers> jobSeekersList = admin.JobSeekers();
		        
		        
		        // Store the jobSeekersList in request scope to pass to JSP or further processing
		        request.setAttribute("jobSeekersList", jobSeekersList);
		        
		        // Forward to a JSP page for rendering or further processing
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/JobSeekerInfo.jsp");
		        dispatcher.forward(request, response);
		        
		    } catch (ClassNotFoundException | SQLException e) {
		        // Handle exceptions appropriately
		        e.printStackTrace();
		        // Optionally, redirect to an error page or handle the error in another way
		    }
		}


	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
