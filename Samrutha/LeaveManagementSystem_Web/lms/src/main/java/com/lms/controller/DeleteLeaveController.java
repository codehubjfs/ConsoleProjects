package com.lms.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.lms.bean.Employee;
import com.lms.dao.LeavesDao;

/**
 * Servlet implementation class DeleteLeaveController
 */
@WebServlet("/DeleteLeave")
public class DeleteLeaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteLeaveController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = (String)request.getSession().getAttribute("username");
		Employee emp = (Employee) request.getSession().getAttribute("employee");
		
        if (username==null) {
        	response.sendRedirect("Logout");
            
        } 
       
        	 
        	 if (emp != null) {
                 String leaveId = request.getParameter("leaveId");
                 try {
					LeavesDao.cancelLeave(Integer.parseInt(leaveId));
					
				 } catch (Exception e) {
					
					e.printStackTrace();
				 }
                 request.getRequestDispatcher("Leave").forward(request, response);
             } else {
            	 request.getRequestDispatcher("index.jsp").forward(request, response);
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
