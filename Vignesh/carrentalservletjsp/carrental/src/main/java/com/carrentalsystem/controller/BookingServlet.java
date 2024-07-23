package com.carrentalsystem.controller;

import com.carrentalsystem.dao.CarDao;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.carrentalsystem.beans.Booking;
import com.carrentalsystem.dao.BookingDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class BookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookingDAO bookingDAO;

    public void init() {
        bookingDAO = new BookingDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String email= (String) request.getSession().getAttribute("email");
        if (email == null) {
		         
			request.getRequestDispatcher("//logout").forward(request, response);
           return;
       }
        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateBooking(request, response);
                    break;
                case "list":
                default:
                    listBookings(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void listBookings(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Booking> listBookings = bookingDAO.selectAllBookings();
        System.out.print("serv");
        request.setAttribute("listBookings", listBookings);
        System.out.println(listBookings);
        request.getRequestDispatcher("views/admin/bookingmanagement.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.print("serv2");
        Booking existingBooking = bookingDAO.selectBooking(id);
        request.setAttribute("booking", existingBooking);
        request.getRequestDispatcher("views/admin/bookingmanagement.jsp").forward(request, response);
    }

    private void updateBooking(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.print("serv3");
        Date startDate = java.sql.Date.valueOf(request.getParameter("startDate"));
        Date endDate = java.sql.Date.valueOf(request.getParameter("endDate"));
        String bookingStatus = request.getParameter("bookingStatus");
        int carId = Integer.parseInt(request.getParameter("carId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        BigDecimal rentalRate = new BigDecimal(request.getParameter("rentalRate"));

        Booking booking = new Booking();
        booking.setBookingId(id);
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setBookingStatus(bookingStatus);
        booking.setCarId(carId);
        booking.setUserId(userId);
        booking.setRentalRate(rentalRate);

        bookingDAO.updateBooking(booking);
        response.sendRedirect("views/admin/DemoBooking.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
