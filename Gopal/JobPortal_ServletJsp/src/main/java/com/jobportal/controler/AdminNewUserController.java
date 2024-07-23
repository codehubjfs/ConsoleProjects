package com.jobportal.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jobportal.bean.Admin;
import com.jobportal.dao.AdminDao;

/**
 * Servlet implementation class AdminNewUserController
 */
public class AdminNewUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNewUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		 String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");

	        Admin newAdmin = new Admin();
	        newAdmin.setName(name);
	        newAdmin.setEmail(email);
	        newAdmin.setPassword(password);
	       AdminDao ad = new AdminDao();
	     
			try {
				ad.createAdmin(newAdmin);
				 request.setAttribute("adminCreated", true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				 request.setAttribute("adminCreated", false);
				e.printStackTrace();
			}
		
            
	       
	       // request.setAttribute("message", "Admin registered successfully!");
	        response.sendRedirect("AdminProfileView");
//	        RequestDispatcher dispatcher = request.getRequestDispatcher("views/Admin/demopro.jsp");
//	        dispatcher.forward(request, response);
		
		
		
	}

}
