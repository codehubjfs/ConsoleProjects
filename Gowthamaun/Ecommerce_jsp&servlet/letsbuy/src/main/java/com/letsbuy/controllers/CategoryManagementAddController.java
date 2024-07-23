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
 * Servlet implementation class CategoryManagementAddController
 */
public class CategoryManagementAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryManagementAddController() {
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
		System.out.println("Inside Add category");
		String categoryName = request.getParameter("catName");
		System.out.println(categoryName);
		Category category = new Category();
		category.setCategoryName(categoryName.toUpperCase());
		category.setVerificationStatus("VERIFIED");
		CategoryDAO categoryDAO = new CategoryDAO();
		categoryDAO.addCategory(category);
		response.sendRedirect("CategoryManagementController");
//		request.getRequestDispatcher("CategoryManagementController").forward(request, response);
	}

}
