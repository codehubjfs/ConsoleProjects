package com.letsbuy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.letsbuy.beans.Category;
import com.letsbuy.beans.SubCategory;
import com.letsbuy.dao.SubCategoryDAO;

/**
 * Servlet implementation class SubCategoryManagementAddController
 */
public class SubCategoryManagementAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubCategoryManagementAddController() {
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
		String subCategoryName = request.getParameter("sub-category-input");
		int categoryId = Integer.parseInt(request.getParameter("category-name"));
		
		SubCategory subCategory = new SubCategory();
		subCategory.setSubCategoryName(subCategoryName);
		subCategory.setVerificationStatus("VERIFIED");
		Category category = new Category();
		category.setCategoryId(categoryId);
		subCategory.setCategory(category);
		
		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		subCategoryDAO.addSubCategory(subCategory);
		System.out.println(subCategoryName+" "+categoryId);
		response.sendRedirect("SubCategoryManagementController");
	}

}
