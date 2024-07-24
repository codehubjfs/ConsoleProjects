package com.hallbookingmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.hallbookingmanagement.beans.Booking;
import com.hallbookingmanagement.dao.BookDAO;

/**
 * Servlet implementation class EditBookingController
 */
public class EditBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBookingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status");
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		Booking book = new Booking();
		book.setBookingId(bookId);
		book.setBookStatus(status);
		boolean statusUpdate;
		try {
			statusUpdate = new BookDAO().updateStatus(book);
			if(statusUpdate) {
				System.out.println("Update Successfully");
			request.getRequestDispatcher("BookingManagementServlet").forward(request, response);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
