package com.hotelmanagement.controller;

import java.io.IOException;

import com.hotelmanagement.bean.RoomType;
import com.hotelmanagement.dao.RoomTypeDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class EditRoomTypesServlet
 */
public class EditRoomTypesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 private RoomTypeDao roomTypeDAO;

	    public void init() {
	        roomTypeDAO = new RoomTypeDao();
	    }
    public EditRoomTypesServlet() {
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
		  try {
			  String typeId = request.getParameter("typeId");
		        String roomName = request.getParameter("roomName");
		        int bedCapacity = Integer.parseInt(request.getParameter("bedCapacity"));
		        String amenity = request.getParameter("amenity");
		        int noOfRooms = Integer.parseInt(request.getParameter("noOfRooms"));
		        int rent = Integer.parseInt(request.getParameter("rent"));

		        RoomType roomType = new RoomType();
		        roomType.setTypeId(Integer.parseInt(typeId));
		        roomType.setRoomName(roomName);
		        roomType.setBedCapacity(bedCapacity);
		        roomType.setAmenity(amenity);
		        roomType.setNoOfRooms(noOfRooms);
		        roomType.setRent(rent);
		        System.out.println("in EDIT");
		        roomTypeDAO.updateRoomType(roomType);
		        System.out.println("IN EDIT 2");
	            response.sendRedirect("ListRoomTypeServlet");
	        } catch (IllegalArgumentException e) {
	            request.setAttribute("error", e.getMessage());
	            //request.getRequestDispatcher("/error.jsp").forward(request, response);
	        }
	      	}

}
