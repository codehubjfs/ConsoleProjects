package com.carrentalsystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.carrentalsystem.beans.Car;
import com.carrentalsystem.beans.CarTemp;
import com.carrentalsystem.dao.AdminCarDao;
import com.carrentalsystem.dao.CarDao;

/**
 * Servlet implementation class InsertStudentServlet
 */
public class AdminInsertCarServlet extends HttpServlet {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AdminCarDao carDao;

	    public void init() {
	        carDao = new AdminCarDao();
	        System.out.print("hi");
	    }
	   
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	String email= (String) request.getSession().getAttribute("email");
	         if (email == null) {
			         
				request.getRequestDispatcher("//logout").forward(request, response);
	            return;
	        }
	    	try {
	            String carName = request.getParameter("carName");
	            String vehicleNo = request.getParameter("vehicleNo");
	            String available = request.getParameter("available");
	            int rentalRate = Integer.parseInt(request.getParameter("rentalRate"));
	            int seatCount = Integer.parseInt(request.getParameter("seatCount"));
	            String fuelType = request.getParameter("fuelType");
	            String carType = request.getParameter("carType");
	            int bags = Integer.parseInt(request.getParameter("bags"));
	            String carImageUrl = request.getParameter("carImageUrl");
	            System.out.print(carName+" "+vehicleNo+" "+available+" "+rentalRate);
	            System.out.print(seatCount+" "+fuelType+" "+carType+" "+ carImageUrl);
	            // Create a new Car object
	            CarTemp newCar = new CarTemp(15, carName, vehicleNo, "yes", rentalRate, seatCount, fuelType, carType, bags, carImageUrl);

	            // Validate the input (if needed)
	            // Example: carDao.validateInput(newCar);

	            // Save the car
	            AdminCarDao carDao = new AdminCarDao();
	            System.out.print("pls1");
	            carDao.insertCar(newCar);
	            System.out.print("pls2");
	            // Redirect to the car list page
	            response.sendRedirect("AdminListCarServlet");
	        } catch (Exception e) {
	            // Handle number format or validation errors
	            e.printStackTrace(); // For debugging
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input data");
	        }
	    }

}
