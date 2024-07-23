package com.hotelmanagement.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hotelmanagement.bean.Booking;
import com.hotelmanagement.dao.BookingDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewBooking
 */
public class ViewBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public ViewBooking() {
        // TODO Auto-generated constructor stub
    }
    BookingDao bk = new BookingDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listBooking(request, response);
	}


	private void listBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		
        
        
        if(request.getSession().getAttribute("username")==null)
        {
        	response.sendRedirect("LogoutAdminServlet");
        }
        if(request.getSession().getAttribute("username")!=null)
        {
        	List<Booking> book = bk.getAllBookings();
   		 request.setAttribute("bookings", book);
   	        
   	        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/viewBooking.jsp");
   	        dispatcher.forward(request, response);
   		
        }
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
