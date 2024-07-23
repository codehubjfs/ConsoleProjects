package com.letsbuy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.letsbuy.beans.Admin;
import com.letsbuy.beans.Category;
import com.letsbuy.beans.SubCategory;
import com.letsbuy.dao.CategoryDAO;
import com.letsbuy.dao.SubCategoryDAO;

/**
 * Servlet implementation class SubCategoryManagementController
 */
public class SubCategoryManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubCategoryManagementController() {
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
		System.out.println("Inside sub-category");
		CategoryDAO categoryDAO = new CategoryDAO();
		List<Category> categories = categoryDAO.getAllCategory();
		SubCategoryDAO subCategoryDAO = new SubCategoryDAO();
		List<SubCategory> subCategories =  subCategoryDAO.getAllSubCategoryMap().entrySet().stream().map((entry)->entry.getValue()).toList();
		request.getSession().setAttribute("subCategoryList", subCategories);
		request.getSession().setAttribute("categoryList", categories);
		request.getRequestDispatcher("views/admin/subcategorymanagement.jsp").forward(request, response);
		}else {
			response.sendRedirect("views/admin/index.jsp");
		}
	}

}
