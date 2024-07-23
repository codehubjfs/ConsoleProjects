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

import com.jobportal.bean.Employer;
import com.jobportal.dao.AdminDao;
import com.jobportal.dao.EmployerDao;

/**
 * Servlet implementation class AdminEmployerView
 */
public class AdminEmployerView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEmployerView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployerDao ed = new EmployerDao();
	    // Retrieve list of JobSeekers from AdminDao
		List<Employer> employer =ed.getAllEmployers1();
		System.out.println(employer);
		
				// Store the jobSeekersList in request scope to pass to JSP or further processing
		request.setAttribute("employer", employer);
		
		
		// Forward to a JSP page for rendering or further processing
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/JobSeekerAdmin.jsp");
		dispatcher.forward(request, response);
		
		
}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}		
		
		    

}
