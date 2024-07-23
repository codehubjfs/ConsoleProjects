package com.letsbuy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.letsbuy.beans.Category;
import com.letsbuy.dao.CategoryDAO;

/**
 * Servlet implementation class CategoryManagementDeleteController
 */
public class CategoryManagementDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryManagementDeleteController() {
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
		System.out.println("Inside delete category");
			int id=Integer.parseInt(request.getParameter("catId"));
			Category category = new Category();
			category.setCategoryId(id);
			category.setVerificationStatus("DELETED");
			CategoryDAO categoryDAO = new CategoryDAO();
			categoryDAO.updateCategoryVerificationStatus(category);
			response.sendRedirect("CategoryManagementController");
//			request.getRequestDispatcher("CategoryManagementController").forward(request, response);
		}

}
