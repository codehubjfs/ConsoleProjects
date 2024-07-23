package com.hotelmanagement.controller;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.hotelmanagement.dao.RoomDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AvailableRoomsServlet
 */
public class AvailableRoomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AvailableRoomsServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String roomType = request.getParameter("roomType");
		 	RoomDAO dao = new RoomDAO();
	        // Replace with your DAO method to fetch available rooms based on roomType
	        List<String> availableRooms = dao.getAvailableRooms(roomType);
	        // Convert list to JSON or comma-separated string
	        System.out.println(availableRooms);
	        String jsonRooms = new Gson().toJson(availableRooms);

	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(jsonRooms);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
