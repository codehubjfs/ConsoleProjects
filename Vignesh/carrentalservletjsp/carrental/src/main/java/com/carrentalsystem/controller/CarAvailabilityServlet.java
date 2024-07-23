package com.carrentalsystem.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.carrentalsystem.dao.CarTempDao;
import com.carrentalsystem.util.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class CarAvailabilityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CarAvailabilityServlet() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	String email= (String) request.getSession().getAttribute("email");
//        if (email == null) {
//		         
//			request.getRequestDispatcher("//logout").forward(request, response);
//           return;
//       }
    	
    	String vehicleNo = request.getParameter("vehicleNo");

        try {
            CarTempDao carDAO = new CarTempDao();
            boolean isAvailable = carDAO.isCarAvailable(vehicleNo);
            request.setAttribute("isAvailable", isAvailable);
            request.getRequestDispatcher("views/admin/index.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    
    }
    
}
