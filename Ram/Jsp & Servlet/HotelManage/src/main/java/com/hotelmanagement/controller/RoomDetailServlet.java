package com.hotelmanagement.controller;

import java.io.IOException;

import com.hotelmanagement.bean.RoomType;
import com.hotelmanagement.dao.RoomDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RoomDetailServlet
 */
public class RoomDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RoomDetailServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  RoomDAO roomDAO = new RoomDAO();
	        RoomType singleRoom = roomDAO.getRoomTypeByName("Single");
	       
	        request.getSession().setAttribute("singleRoom", singleRoom);
	        System.out.println("First Come");
	        System.out.println(singleRoom);
	        request.getRequestDispatcher("CommonRoomServlet").forward(request, response);
//	        response.sendRedirect("CommonRoomServlet");
//	        response.sendRedirect("views/user/room.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
