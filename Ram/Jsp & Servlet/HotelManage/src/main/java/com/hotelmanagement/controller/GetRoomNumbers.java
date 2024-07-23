package com.hotelmanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.hotelmanagement.bean.Room;
import com.hotelmanagement.dao.RoomDAO;
import com.hotelmanagement.dao.RoomTypeDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetRoomNumbers
 */
public class GetRoomNumbers extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetRoomNumbers() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String roomTypeName = request.getParameter("roomType");

	        RoomTypeDao roomTypeDao = new RoomTypeDao();
	        int typeId = roomTypeDao.getTypeIdByRoomName(roomTypeName);

	        RoomDAO roomDao = new RoomDAO();
	        List<Room> rooms = roomDao.getRoomsByTypeId(typeId);

	        request.setAttribute("selectedRoomType", roomTypeName);

	        request.setAttribute("rooms", rooms);
	        request.getRequestDispatcher("views/user/booking.jsp").forward(request, response);
	}

}
