package com.issueraisesystem.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.issueraisesystem.dao.StudentDAO;
import com.issueraisesystem.dao.WardenDAO;
import com.issueraisesystem.dao.WorkersDAO;

/**
 * Servlet implementation class AdminDeleteWorkerController
 */
public class AdminDeleteWorkerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminDeleteWorkerController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String itemId = request.getParameter("id");
		 
		 System.out.println(itemId);
		 WorkersDAO workerDao=new WorkersDAO();
	        // Perform deletion in DAO
	        boolean deleted=false;
			try {
				deleted = workerDao.deleteWorker(itemId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        if (deleted) {
	            // Optionally set a success message or redirect
	        	System.out.println("deleted");
	        	request.getRequestDispatcher("/AdminWorkersController").forward(request, response);
	            
	        } else {
	            // Handle deletion failure
	            // You can redirect or show an error message on the same page
	        	request.setAttribute("error", "Failed to delete item");
	            request.getRequestDispatcher("views/Admin/usermanagement.jsp").forward(request, response);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
