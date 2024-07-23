package com.issueraisesystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.issueraisesystem.beans.WorkersDetails;
import com.issueraisesystem.dao.WorkersDAO;

/**
 * Servlet implementation class AdminAddWorkerController
 */
public class AdminAddWorkerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddWorkerController() {
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
		
		String name=request.getParameter("workerName");
		String department=request.getParameter("department");
		String phonenumber=request.getParameter("phoneNumber");
		
		WorkersDetails workerDetails=new WorkersDetails();
		workerDetails.setName(name);
		workerDetails.setDepartment(department);
		workerDetails.setPhonenumber(phonenumber);
		WorkersDAO workersDao=new WorkersDAO();
		try {
			workersDao.addWorkers(workerDetails);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/AdminWorkerManagementController").forward(request, response);
		
		
	}

}
