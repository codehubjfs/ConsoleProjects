package com.jobportal.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class AdminLogout
 */
public class AdminLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		HttpSession session = request.getSession();
//		session.removeAttribute("admin"); //remove admin
//		session.invalidate();//remove all data
//		
//		
//		   if(session.getAttribute("admin")==null){
//			   
//				request.getRequestDispatcher("/views/Admin/AdminLogin.jsp").forward(request, response);
//		   }
//
//	
//	}
		HttpSession session = request.getSession(false); // Get existing session without creating a new one

		if (session != null) {
		    session.removeAttribute("admin"); // Remove specific attribute 'admin' from session
		    session.invalidate(); // Invalidate (remove) the entire session
		}

		// Redirect to the login page
		request.getRequestDispatcher("/views/Admin/AdminLogin.jsp").forward(request, response);
	
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}	
		

}
