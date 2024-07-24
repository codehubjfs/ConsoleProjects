package com.hallbookingmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.hallbookingmanagement.beans.Hall;
import com.hallbookingmanagement.dao.HallDAO;

/**
 * Servlet implementation class HallDetailServlet
 */
public class HallDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HallDetailServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hallId = Integer.parseInt(request.getParameter("hall_id"));
		Hall hall = new HallDAO().getAll().stream().filter(h->h.getHallId()==hallId).findFirst().orElse(null);
		if(hall!=null) {
			request.getSession().setAttribute("hallDetail", hall);
			request.getRequestDispatcher("/view/hallDetails.jsp").forward(request, response);
		}
		else {
			System.out.println("Hall is null");
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
