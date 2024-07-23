package com.hotelmanagement.controller;

import java.io.IOException;

import com.hotelmanagement.bean.RoomType;
import com.hotelmanagement.dao.RoomTypeDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AddRoomTypeServlet
 */
public class AddRoomTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 private RoomTypeDao roomTypeDAO;

	    public void init() {
	        roomTypeDAO = new RoomTypeDao();
	    }

    public AddRoomTypeServlet() {
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
		  int typeId = Integer.parseInt(request.getParameter("type_id"));
	        String roomName = request.getParameter("room_name");
	        int bedCapacity = Integer.parseInt(request.getParameter("bed_capacity"));
	        String amenity = request.getParameter("amenity");
	        int noOfRooms = Integer.parseInt(request.getParameter("no_of_room"));
	        int rent = Integer.parseInt(request.getParameter("rent"));

	        // Create RoomType object
	        RoomType roomType = new RoomType();
	        roomType.setTypeId(typeId);
	        roomType.setRoomName(roomName);
	        roomType.setBedCapacity(bedCapacity);
	        roomType.setAmenity(amenity);
	        roomType.setNoOfRooms(noOfRooms);
	        roomType.setRent(rent);

	        // Call DAO to insert into database
	        roomTypeDAO.addRoomType(roomType);
	        // Redirect to a success page or reload the room types list
	        response.sendRedirect("ListRoomTypeServlet");
	        //response.sendRedirect("views/admin/roomtype.jsp");
	    }
	}


