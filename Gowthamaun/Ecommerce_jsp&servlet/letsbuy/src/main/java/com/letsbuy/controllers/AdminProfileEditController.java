package com.letsbuy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.letsbuy.beans.Admin;
import com.letsbuy.dao.AdminDAO;

/**
 * Servlet implementation class AdminProfileEditController
 */
public class AdminProfileEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminDAO adminDAO = new AdminDAO();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProfileEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
	        response.setHeader("Pragma", "no-cache");
	        response.setDateHeader("Expires", 0);
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if(admin==null) {
			response.sendRedirect("views/admin/login.jsp");
		}else {
			String password = request.getParameter("edit-profile-password");
			admin.setPassword(password);
			boolean status = adminDAO.changeAdminPassword(admin);
			if(status) {
				request.getSession().setAttribute("admin", admin);
				System.out.println("Admin password has been edited successfully");
			}
			response.sendRedirect("AdminManagementController");
		}
	}

}
