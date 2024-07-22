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
 * Servlet implementation class ApproveController
 */
@WebServlet("/approve")
public class ApproveLeaveController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveLeaveController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        Employee emp = (Employee) request.getSession().getAttribute("employee");

        if (username == null) {
            response.sendRedirect("Logout");
        } else if (emp != null) {
            String leaveId = request.getParameter("leaveId");
            System.out.println("leaveId: " + leaveId);

            if (leaveId != null && !leaveId.trim().isEmpty()) {
                try {
                    LeavesDao.approveLeave(Integer.parseInt(leaveId));
                	//System.out.println("Approved");
                    request.setAttribute("approveSuccess", "Leave Approved Successfully");
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    request.setAttribute("error", "Invalid leave ID format.");
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("error", "An error occurred while approving the leave.");
                }
            } else {
                request.setAttribute("error", "Leave ID is required.");
            }
            request.getRequestDispatcher("requestLeave").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
