package com.hotelmanagement.controller;

import java.io.IOException;

import com.hotelmanagement.bean.RoomType;
import com.hotelmanagement.dao.RoomDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class CommonRoomServlet
 */
public class CommonRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CommonRoomServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RoomDAO roomDAO = new RoomDAO();

	        // Retrieve room details for Double Room
	        RoomType doubleRoom = roomDAO.getRoomTypeByName("Double");
	        HttpSession session = request.getSession();
	        session.setAttribute("doubleRoom", doubleRoom);

	        // Retrieve room details for Deluxe Room
	        RoomType deluxeRoom = roomDAO.getRoomTypeByName("Deluxe Room");
	        session.setAttribute("deluxeRoom", deluxeRoom);

	        // Retrieve room details for Single Room
	        RoomType singleRoom = roomDAO.getRoomTypeByName("Single");
	        session.setAttribute("singleRoom", singleRoom);
	        System.out.println("Second Come");
	        System.out.println(singleRoom);
	        // Retrieve room details for Luxury Room
	        RoomType luxuryRoom = roomDAO.getRoomTypeByName("Luxury");
	        session.setAttribute("luxuryRoom", luxuryRoom);
	        
	        System.out.println("Third Come");
	        // Forward to room.jsp
	        response.sendRedirect("views/user/room.jsp");
//	        request.getRequestDispatcher("views/user/room.jsp").forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
