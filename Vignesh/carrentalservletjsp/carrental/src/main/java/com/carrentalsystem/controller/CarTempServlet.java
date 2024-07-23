package com.carrentalsystem.controller;



import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.carrentalsystem.beans.CarTemp;
import com.carrentalsystem.dao.CarTempDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class CarTempServlet extends HttpServlet {

    private CarTempDao carDao;

    @Override
    public void init() throws ServletException {
        super.init();
       carDao = new CarTempDao();
    }

    
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//response.sendRedirect("views/user/index.jsp");
//    	String email= (String) request.getSession().getAttribute("email");
//        if (email == null) {
//		         
//			request.getRequestDispatcher("//logout").forward(request, response);
//           return;
//       }
        System.out.print("crad card");
        // Retrieve and set data for sedan cars
        List<CarTemp> sedanCars;
		try {
			System.out.print("crad card1");
			sedanCars = carDao.getAvailableCarsByType("sedan");
			
	        request.setAttribute("sedanCars", sedanCars);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        // Retrieve and set data for SUV cars
        List<CarTemp> suvCars;
		try {
			System.out.print("crad card2");
			suvCars = carDao.getAvailableCarsByType("SUV");
			
	        request.setAttribute("suvCars", suvCars);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        // Retrieve and set data for luxury cars
        List<CarTemp> luxuryCars;
		try {
			System.out.print("crad card3");
			luxuryCars = carDao.getAvailableCarsByType("luxury");
			 
		        request.setAttribute("luxuryCars", luxuryCars);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       

        // Forward to JSP
        request.getRequestDispatcher("views/user/carpage.jsp").forward(request, response);
    }
 
}
