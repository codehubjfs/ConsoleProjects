package com.hotelmanagement.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.hotelmanagement.dao.RoomDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DeleteRoomServlet
 */
public class DeleteRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 private RoomDAO roomDao;

	    public void init() {
	        roomDao = new RoomDAO();
	    }
    public DeleteRoomServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String roomIdStr = request.getParameter("roomId");
	        if (roomIdStr == null || roomIdStr.trim().isEmpty()) {
	            // Handle the error, e.g., by setting an error message in the request
	            request.setAttribute("errorMessage", "Room ID is required.");
	           // request.getRequestDispatcher("roomManagement.jsp").forward(request, response);
	            return;
	        }

	        try {
	            int roomId = Integer.parseInt(roomIdStr);
	            RoomDAO roomDAO = new RoomDAO();
	            roomDAO.deleteRoom(roomId);
	            response.sendRedirect("ListRoomsServlet");
	           
	        } catch (NumberFormatException e) {
	            // Handle the number format exception
	            request.setAttribute("errorMessage", "Invalid Room ID.");
	            //request.getRequestDispatcher("roomManagement.jsp").forward(request, response);
	        }

	        
	}

}
