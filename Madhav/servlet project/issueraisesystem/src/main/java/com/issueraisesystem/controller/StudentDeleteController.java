package com.issueraisesystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.issueraisesystem.dao.StudentDAO;

/**
 * Servlet implementation class StudentDeleteController
 */
public class StudentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String itemId = request.getParameter("id");
		 
		 System.out.println(itemId);
		 StudentDAO studentDao=new StudentDAO();
	        // Perform deletion in DAO
	        boolean deleted=false;
			try {
				deleted = studentDao.deleteStudent(itemId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        if (deleted) {
	            // Optionally set a success message or redirect
	        	System.out.println("deleted");
	        	request.getRequestDispatcher("/AdminStudentUserController").forward(request, response);
	            
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
