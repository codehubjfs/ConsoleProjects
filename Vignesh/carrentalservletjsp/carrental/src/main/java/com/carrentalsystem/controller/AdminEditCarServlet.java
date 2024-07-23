package com.carrentalsystem.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.carrentalsystem.beans.Car;
import com.carrentalsystem.beans.CarTemp;
import com.carrentalsystem.dao.AdminCarDao;
@WebServlet("/AdminEditCarServlet")
public class AdminEditCarServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private AdminCarDao carDao;
	 public void init() {
	        carDao = new AdminCarDao();
	    }
	 
	 public AdminEditCarServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String email= (String) request.getSession().getAttribute("email");
	         if (email == null) {
			         
				request.getRequestDispatcher("//logout").forward(request, response);
	            return;
	        }
			System.out.println("editing1");
			   int id = Integer.parseInt(request.getParameter("id"));
		        String carName = request.getParameter("carName");
		        String vehicleNo = request.getParameter("vehicleNo");
		        String available = request.getParameter("available");
		        int rentalRate = Integer.parseInt(request.getParameter("rentalRate"));
		        int seatCount = Integer.parseInt(request.getParameter("seatCount"));
		        String fuelType = request.getParameter("fuelType");
		        String carType = request.getParameter("carType");
		        int bags = Integer.parseInt(request.getParameter("bags"));
		        String carImageUrl = request.getParameter("carImageUrl");
		        CarTemp car = new CarTemp(id, carName, vehicleNo, available, rentalRate, seatCount, fuelType, carType, bags, carImageUrl);
		        try {
					carDao.updateCar(car);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        response.sendRedirect("CarController");
}




   
   



}
