package com.hallbookingmanagement.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.hallbookingmanagement.dao.CustomerDAO;
import com.hallbookingmanagement.beans.Customer;

public class CustomerManagementServlet extends HttpServlet {

    private CustomerDAO customerDAO;

    @Override
    public void init() throws ServletException {
        customerDAO = new CustomerDAO(); // Assuming CustomerDAO has the appropriate methods
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		
			List<Customer> list = new CustomerDAO().getAll();
			request.setAttribute("customerList", list);
			request.getRequestDispatcher("/view/Admin/customerManagement.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }
}
