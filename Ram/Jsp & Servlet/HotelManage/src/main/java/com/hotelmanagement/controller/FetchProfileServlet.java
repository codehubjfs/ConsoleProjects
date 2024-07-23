package com.hotelmanagement.controller;

import java.io.IOException;
import java.util.List;

import com.hotelmanagement.bean.Booking;
import com.hotelmanagement.bean.LoginUser;
import com.hotelmanagement.bean.User;
import com.hotelmanagement.dao.BookingDao;
import com.hotelmanagement.dao.LoginUserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class FetchProfileServlet
 */
public class FetchProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FetchProfileServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("C 1");
		 HttpSession session = request.getSession(false);
	        if (session != null) {
	        	System.out.println("C 2");
	            String email = (String) session.getAttribute("user");
	            System.out.println("Email : "+email);
	            
	                if (email != null) {
	                	LoginUserDao userDao = new LoginUserDao();
	                    User user = userDao.getDetails(email);

	                    if (user != null) {
	                        BookingDao bookingDao = new BookingDao();
	                        List<Booking> bookings = bookingDao.getBookingsByPhone(user.getPhone());

	                        request.setAttribute("user", user);
	                        request.setAttribute("bookings", bookings);
	                        request.getRequestDispatcher("views/user/profile.jsp").forward(request, response);
	                        return;
	                    }
	                }
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
