package com.letsbuy.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.letsbuy.beans.Admin;
import com.letsbuy.beans.Category;
import com.letsbuy.dao.CategoryDAO;

/**
 * Servlet implementation class CategoryManagementController
 */
public class CategoryManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryManagementController() {
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
		if(admin!=null) {
		CategoryDAO categoryDAO = new CategoryDAO();
		List<Category> categories = categoryDAO.getAllCategory();
		
		request.getSession().setAttribute("categoryList", categories);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/admin/categorymanagement.jsp");
		requestDispatcher.forward(request, response);
		}else {
			response.sendRedirect("views/admin/index.jsp");
		}
	}

}
