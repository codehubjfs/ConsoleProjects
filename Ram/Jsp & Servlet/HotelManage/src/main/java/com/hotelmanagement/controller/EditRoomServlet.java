package com.hotelmanagement.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.hotelmanagement.bean.Room;
import com.hotelmanagement.dao.RoomDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class EditRoomServlet
 */
public class EditRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  private RoomDAO roomDao;

	    public void init() {
	        roomDao = new RoomDAO();
	    }
    public EditRoomServlet() {
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
		 int roomId = Integer.parseInt(request.getParameter("roomId"));
	        int typeId = Integer.parseInt(request.getParameter("typeId"));
	        String roomStatus = request.getParameter("roomStatus");
	        String roomCondition = request.getParameter("roomCondition");

	        Room room = new Room();
	        room.setRoomId(roomId);
	        room.setTypeId(typeId);
	        room.setRoomStatus(roomStatus);
	        room.setRoomCondition(roomCondition);

	            roomDao.updateRoom(room);


	        response.sendRedirect("ListRoomsServlet");
	}
	        

}

