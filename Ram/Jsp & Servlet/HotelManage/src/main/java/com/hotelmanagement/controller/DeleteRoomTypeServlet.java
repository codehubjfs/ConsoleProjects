package com.hotelmanagement.controller;

import java.io.IOException;

import com.hotelmanagement.dao.RoomTypeDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DeleteRoomTypeServlet
 */
public class DeleteRoomTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeleteRoomTypeServlet() {
        // TODO Auto-generated constructor stub
    }

    private RoomTypeDao roomTypeDAO;

    public void init() {
        roomTypeDAO = new RoomTypeDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String typeId = request.getParameter("typeId");
        roomTypeDAO.deleteRoomType(typeId);
	        // Redirect to a success page or reload the room types list
            response.sendRedirect("ListRoomTypeServlet");
	}

}
