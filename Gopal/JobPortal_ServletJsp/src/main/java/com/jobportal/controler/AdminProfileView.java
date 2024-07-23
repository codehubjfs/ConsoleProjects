package com.jobportal.controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.jobportal.bean.Admin;
import com.jobportal.dao.AdminDao;

/**
 * Servlet implementation class AdminProfileView
 */
public class AdminProfileView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProfileView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		  HttpSession session = request.getSession();
//          Admin admin = (Admin) session.getAttribute("admin");
            
//            AdminDao da = new AdminDao();
//         Admin admin =   da.findAdminByEmail("kumar121@gmail.com");
		 Boolean adminCreated = (Boolean) request.getAttribute("adminCreated");
		    if (adminCreated != null && adminCreated) {
		        request.setAttribute("adminCreationMessage", "Admin registered successfully!");
		    }
		  HttpSession session = request.getSession();
	        Admin admin = (Admin) session.getAttribute("admin");
          if (admin == null) {
              response.sendRedirect(request.getContextPath() + "/views/Admin/AdminLogin.jsp");
              return;
          }

          request.setAttribute("admin", admin);
          RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Admin/demopro.jsp");
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
