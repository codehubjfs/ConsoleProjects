package com.jobportal.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.jobportal.bean.Admin;
import com.jobportal.dao.AdminDao;

/**
 * Servlet implementation class AdminProfileEdite
 */
public class AdminProfileEdite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProfileEdite() {
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
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//		int id =Integer.parseInt(request.getParameter("id"));
//		 String name = request.getParameter("name");
//	        String email = request.getParameter("email");
//	        String oldPassword = request.getParameter("oldPassword");
//	        String newPassword = request.getParameter("password");
//		AdminDao ad = new AdminDao();
//		  HttpSession session = request.getSession();
//	        Admin admin = (Admin) session.getAttribute("admin");
////            int id =Integer.parseInt(request.getParameter("id"));
////	        String name = request.getParameter("name");
////	        String email = request.getParameter("email");
////	        String oldPassword = request.getParameter("oldPassword");
////	        String newPassword = request.getParameter("password");
////           System.out.println(oldPassword+" "+newPassword+" "+name +" "+email+"gopal welcome"+""+id);
//           System.out.println(newPassword+" old");
//           System.out.println(newPassword+" new pas");
//           System.out.println(name +" name");
//           System.out.println(email+"gopal welcome"+"email");
//           System.out.println("id "+id);
//	        if (admin != null && admin.getPassword().equals(oldPassword)) {
////	        	admin.setAdminId(id);
//	            admin.setName(name);
//	            admin.setEmail(email);
//	            admin.setPassword(newPassword);
//	            try {
//					ad.updateAdmin(admin);
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//	            session.setAttribute("admin", admin);
//	            request.setAttribute("message", "Profile updated successfully!");
//	        } else {
//	            request.setAttribute("error", "Old password is incorrect.");
//	        }
//
//	        response.sendRedirect("AdminProfileView");
//	        
////	        RequestDispatcher dispatcher = request.getRequestDispatcher("views/Admin/demopro.jsp");
////	        dispatcher.forward(request, response);
//	    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Retrieve form parameters
	    String idStr = request.getParameter("id");
	    String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    String oldPassword = request.getParameter("oldPassword");
	    String newPassword = request.getParameter("newPassword"); // Correct parameter name

	    // Log to check values received
	    System.out.println("id: " + idStr);
	    System.out.println("name: " + name);
	    System.out.println("email: " + email);
	    System.out.println("oldPassword: " + oldPassword);
	    System.out.println("newPassword: " + newPassword);

	    // Check if idStr is null or empty
	    if (idStr == null || idStr.isEmpty()) {
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Admin ID is missing.");
	        return;
	    }

	    // Parse id to integer
	    int id = Integer.parseInt(idStr);

	    // Get session and admin object
	    HttpSession session = request.getSession();
	    Admin admin = (Admin) session.getAttribute("admin");

	    // Check old password and update admin details
	    if (admin != null && admin.getPassword().equals(oldPassword)) {
	    	admin.setAdminId(id);
	        admin.setName(name);
	        admin.setEmail(email);
	        admin.setPassword(newPassword);
	        AdminDao ad = new AdminDao();
	        try {
				ad.updateAdmin(admin);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        session.setAttribute("admin", admin);
	        request.setAttribute("message", "Profile updated successfully!");
	    } else {
	        request.setAttribute("error", "Old password is incorrect.");
	    }

	    // Redirect to profile view
	    response.sendRedirect("AdminProfileView");
	}

	}


