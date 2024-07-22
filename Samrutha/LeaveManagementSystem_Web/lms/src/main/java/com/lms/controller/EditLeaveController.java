package com.lms.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

import com.lms.bean.Employee;
import com.lms.bean.Leaves;
import com.lms.dao.LeavesDao;

/**
 * Servlet implementation class EditLeaveController
 */
@WebServlet("/editLeave")
public class EditLeaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditLeaveController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
        if (session != null && username!=null) {
            Employee emp = (Employee) session.getAttribute("employee");
            if (emp != null) {
            	String leaveId = request.getParameter("leaveId");
                String leaveType = request.getParameter("leaveType");
                LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
                LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
                String reason = request.getParameter("reason");
                String assignWork = request.getParameter("assignWork");
                
               
                // Create a new Leaves object with the updated data
                Leaves leave = new Leaves();
                leave.setLeaveId(Integer.parseInt(leaveId));
                leave.setLeaveType(leave.mapToEnum(leaveType));
                leave.setStartDate(startDate);
                leave.setEndDate(endDate);
                leave.setReason(reason);
                leave.setAssignWork(assignWork);

                // Update the leave in the database
                try {
        			LeavesDao.updateLeave(leave);
        		} catch (Exception e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
            } else {
            	request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
        	request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        request.getRequestDispatcher("Leave").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
