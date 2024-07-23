package com.letsbuy.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.letsbuy.beans.Category;
import com.letsbuy.dao.CategoryDAO;

/**
 * Servlet implementation class CategoryManagementEditController
 */
public class CategoryManagementEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryManagementEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("HII !! Inside Edit category");
		int id = Integer.parseInt(request.getParameter("category-id"));
		String status = (String) request.getParameter("v-status");
		System.out.println(status+" "+id);
		Category category = new Category();
		category.setCategoryId(id);
		category.setVerificationStatus(status);
		CategoryDAO categoryDAO = new CategoryDAO();
		categoryDAO.updateCategoryVerificationStatus(category);
		response.sendRedirect("CategoryManagementController");
	}

}
