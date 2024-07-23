package com.hotelmanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.hotelmanagement.bean.Room;
import com.hotelmanagement.dao.RoomDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ListRoomsServlet
 */
public class ListRoomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoomDAO roomDao;

    public void init() {
        roomDao = new RoomDAO();
    }

    public ListRoomsServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
        
        if(request.getSession().getAttribute("username")==null)
        {
        	response.sendRedirect("LogoutAdminServlet");
        }
		
        if(request.getSession().getAttribute("username")!=null)
        {
        	try {
	            listRooms(request, response);
	        } catch (SQLException e) {
	            throw new ServletException(e);
	        }
        }
		
	}

	private void listRooms(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		 List<Room> listRooms = roomDao.listRooms();
		 for(Room r : listRooms)
		 {
			 System.out.println(r.getRoomId()+r.getRoomCondition()+r.getRoomName()+r.getRoomStatus());
		 }
	        request.setAttribute("listRooms", listRooms);
	        request.getRequestDispatcher("views/admin/rooms.jsp").forward(request, response);
	    }
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
