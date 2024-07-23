package com.issueraisesystem.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.issueraisesystem.beans.WorkersDetails;
import com.issueraisesystem.dao.WorkersDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditWorkerController
 */
public class EditWorkerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EditWorkerController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int itemId =Integer.parseInt(request.getParameter("id")) ;
		 WorkersDetails worker=new WorkersDetails();
		 System.out.println(itemId);
		 
		 String name=request.getParameter("name");
		 String department=request.getParameter("department");
		 
		 WorkersDAO workerDao=new WorkersDAO();
	        // Perform deletion in DAO
	        boolean updated=false;
			try {
				worker.setWorkersid(itemId);
				worker.setDepartment(department);
				worker.setName(name);
				updated = workerDao.updateWorkers(worker);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        if (updated) {
	            // Optionally set a success message or redirect
	        	System.out.println("updated");
	        	request.getRequestDispatcher("/AdminWorkerManagementController").forward(request, response);
	            
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
