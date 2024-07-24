package com.hallbookingmanagement.controller;

import com.hallbookingmanagement.beans.Booking;
import com.hallbookingmanagement.dao.BookingDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class BookingManagementServlet
 */
public class BookingManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Booking> booking = new BookingDAO().getAll();
			request.setAttribute("bookingList",booking);
			request.getRequestDispatcher("view/Admin/bookingManagement.jsp").forward(request, response);

        } catch (SQLException e) {
            throw new RuntimeException(e);
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
