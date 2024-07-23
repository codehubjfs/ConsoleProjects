package com.hotelmanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.hotelmanagement.bean.Room;
import com.hotelmanagement.dao.RoomDAO;
import com.hotelmanagement.dao.RoomTypeDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RoomServlet
 */
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	   private RoomDAO roomDAO = new RoomDAO();
	    private RoomTypeDao roomTypeDao = new RoomTypeDao();
    public RoomServlet() {
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String roomType = request.getParameter("roomType");
	        int typeId = getTypeIdByRoomName(roomType);

	        List<Room> availableRooms = roomDAO.getAvailableRoomsByType(typeId);

	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        for (Room room : availableRooms) {
	            out.println("<option value=\"" + room.getRoomId() + "\">" + room.getRoomId() + "</option>");
	        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roomId = Integer.parseInt(request.getParameter("roomSelection"));
        roomDAO.updateRoomStatusToBooked(roomId);
        
        response.sendRedirect("views/user/confirmation.jsp");
	}

	
	private int getTypeIdByRoomName(String roomName) {
        return roomTypeDao.getAllRoomTypes().stream()
                .filter(rt -> rt.getRoomName().equalsIgnoreCase(roomName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid room type"))
                .getTypeId();
    }
}
