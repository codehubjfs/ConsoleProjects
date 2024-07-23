package com.letsbuy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.letsbuy.beans.Category;
import com.letsbuy.beans.SubCategory;
import com.letsbuy.dao.CategoryDAO;
import com.letsbuy.dao.SubCategoryDAO;

/**
 * Servlet implementation class SubCategoryManagementDeleteController
 */
public class SubCategoryManagementDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubCategoryManagementDeleteController() {
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
		System.out.println("Inside delete subcategory");
		int id=Integer.parseInt(request.getParameter("subcatId"));
		SubCategory subCategory = new SubCategory();
		subCategory.setSubCategoryId(id);
		subCategory.setVerificationStatus("DELETED");
		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		subCategoryDAO.updateSubCategoryVerificationStatus(subCategory);
		response.sendRedirect("SubCategoryManagementController");
	}

}
