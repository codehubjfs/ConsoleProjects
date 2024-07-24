package com.hallbookingmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.hallbookingmanagement.beans.Hall;
import com.hallbookingmanagement.dao.HallDAO;

/**
 * Servlet implementation class EditHallServlet
 */
public class EditHallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditHallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hallId = Integer.parseInt(request.getParameter("hallId"));
		String hallName = request.getParameter("hallName");
		int capacity = Integer.parseInt(request.getParameter("capacity")); 
		double price = Double.parseDouble(request.getParameter("price"));
		String location = request.getParameter("location");
		String locationLink = request.getParameter("locationLink");
		Hall hall = new Hall();
		hall.setHallId(hallId);
		hall.setHallName(hallName);
		hall.setCapacity(capacity);
		hall.setPrice(price);
		hall.setLocation(location);
		hall.setLocationLink(locationLink);
		try {
			boolean isUpdate = new HallDAO().updateHall(hall);
			if(isUpdate) {
				System.out.println("Updated hall Success fully");
				request.getRequestDispatcher("HallManagementServlet").forward(request, response);
			}
			else {
				System.out.println("no Updates occur");
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
