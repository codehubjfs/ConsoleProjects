package com.hotelmanagement.controller;

import java.io.IOException;
import java.util.List;

import com.hotelmanagement.bean.RoomType;
import com.hotelmanagement.dao.RoomTypeDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ListRoomTypeServlet
 */
public class ListRoomTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    private RoomTypeDao roomTypeDAO;

    public void init() {
        roomTypeDAO = new RoomTypeDao();
    }
    public ListRoomTypeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	        response.setHeader("Pragma", "no-cache");
	        response.setHeader("Expires", "0");

	        if (request.getSession().getAttribute("username") == null) {
	            response.sendRedirect("LogoutAdminServlet");
	            return;
	        }

	        List<RoomType> roomTypes = roomTypeDAO.getAllRoomTypes();
	        request.setAttribute("roomTypes", roomTypes);
	        request.getRequestDispatcher("views/admin/roomtype.jsp").forward(request, response);
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
