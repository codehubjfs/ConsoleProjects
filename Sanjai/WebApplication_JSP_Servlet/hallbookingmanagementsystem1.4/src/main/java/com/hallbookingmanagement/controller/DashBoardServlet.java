package com.hallbookingmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.YearMonth;

import com.hallbookingmanagement.dao.BookingDAO;

/**
 * Servlet implementation class DashBoardServlet
 */
public class DashBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long pendings;
		try {
			YearMonth lastMonth = YearMonth.now().minusMonths(1);
			YearMonth currentMonth = YearMonth.now();
			long previousMonthCount = new BookingDAO().getAll().stream().filter(x->x.getStartDate().isAfter(lastMonth.atDay(1).minusDays(1)) && x.getStartDate().isBefore(lastMonth.plusMonths(1).atDay(1).minusDays(1))).count();
			request.setAttribute("previous", previousMonthCount);
			
			long currentMonthCount = new BookingDAO().getAll().stream().filter(x->x.getStartDate().isAfter(currentMonth.atDay(1).minusDays(1)) && x.getStartDate().isBefore(currentMonth.plusMonths(1).atDay(1).minusDays(1))).count();
			request.setAttribute("thisMonth", currentMonthCount);
			System.out.println(new BookingDAO().getAll());
			pendings = new BookingDAO().getAll().stream().filter(x->x.getBookStatus().equals("PENDING")).count();
			request.setAttribute("pending", pendings);
			
			System.out.println("DashBoard servlet");
			request.getRequestDispatcher("/view/Admin/dashBoard.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/Admin/dashBoard.jsp").forward(request, response); 
	}

}
