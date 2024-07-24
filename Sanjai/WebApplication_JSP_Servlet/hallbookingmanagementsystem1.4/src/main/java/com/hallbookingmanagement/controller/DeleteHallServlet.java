package com.hallbookingmanagement.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.hallbookingmanagement.beans.Hall;
import com.hallbookingmanagement.dao.HallDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteHallServlet
 */
public class DeleteHallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeleteHallServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hallId = Integer.parseInt(request.getParameter("hallId"));
		Hall hall = new Hall();
		hall.setHallId(hallId);
		try {
			boolean isDelete = new HallDAO().delete(hall);
			if(isDelete) {
				System.out.print("Deleted Hall successFully");
				request.getRequestDispatcher("HallManagementServlet").forward(request, response);
			}
			else {
				System.out.print("Cannot Deleted successFully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
