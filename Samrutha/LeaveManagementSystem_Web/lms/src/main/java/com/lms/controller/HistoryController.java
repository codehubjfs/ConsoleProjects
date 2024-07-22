package com.lms.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.lms.bean.ApplicationStatus;
import com.lms.bean.Employee;
import com.lms.bean.Leaves;
import com.lms.dao.LeavesDao;

/**
 * Servlet implementation class HistoryController
 */
@WebServlet("/History")
public class HistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryController() {
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
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
        if (username==""||username==null || request.getSession()==null) {
        	response.sendRedirect("Logout");
            
        } 
		
		
	        if (emp != null || username!=null) {
	            List<Leaves> leaves = LeavesDao.selectLeavesByEmpId(emp);
	            System.out.println("Controller:");
	            for(Leaves l: leaves) {
	            	System.out.println(l);
	            }
	            System.out.println();
	            request.setAttribute("leaves", leaves);
	            if (leaves != null) {
	        
		            List<Leaves> approvedLeaves = leaves.stream().filter((l) -> l.getStatus().equals(ApplicationStatus.APPROVED)).collect(Collectors.toList());
		            List<Leaves> rejectedLeaves = leaves.stream().filter((l) -> l.getStatus().equals(ApplicationStatus.REJECTED)).collect(Collectors.toList());
		            List<Leaves> cancelledLeaves = leaves.stream().filter((l) -> l.getStatus().equals(ApplicationStatus.CANCELLED)).collect(Collectors.toList());
		            request.setAttribute("approvedleaves", approvedLeaves);
		            request.setAttribute("rejectedleaves", rejectedLeaves);
		            request.setAttribute("cancelledleaves", cancelledLeaves);
		            
		            System.out.println("Approved:");
		            for (Leaves l : approvedLeaves) {
		            	System.out.println(l);
		            }
		            System.out.println("Rejected:");
		            for (Leaves l : rejectedLeaves) {
		            	System.out.println(l);
		            }
		            System.out.println("Cancelled:");
		            for (Leaves l : cancelledLeaves) {
		            	System.out.println(l);
		            }
	            } else {
		        	System.out.println("null");
		            request.setAttribute("approvedleaves", new ArrayList<Leaves>());
		            request.setAttribute("rejectedleaves", new ArrayList<Leaves>());
		            request.setAttribute("cancelledleaves", new ArrayList<Leaves>());
		        }
	            request.getRequestDispatcher("views/Employee/History.jsp").forward(request, response);
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
