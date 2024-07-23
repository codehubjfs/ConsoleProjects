package com.carrentalsystem.controller;


import com.carrentalsystem.dao.CarDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;


public class GetRentalRateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CarDao carDao;

    public void init() {
        carDao = new CarDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	String email= (String) request.getSession().getAttribute("email");
//        if (email == null) {
//		         
//			request.getRequestDispatcher("//logout").forward(request, response);
//           return;
//       }
    	String carType = request.getParameter("carType");
        double rentalRate = 0;

     //   rentalRate = carDao.getRentalRate(carType);

        response.setContentType("text/plain");
        response.getWriter().write(String.valueOf(rentalRate));
    }
}

