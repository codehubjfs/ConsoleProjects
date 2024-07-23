package com.lms.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.lms.bean.Department;
import com.lms.bean.Employee;
import com.lms.bean.Login;
import com.lms.bean.Role;
import com.lms.dao.DepartmentDao;
import com.lms.dao.EmployeeDao;
import com.lms.dao.LoginDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");
        HttpSession session = request.getSession();
        Login user = LoginDao.getUserDetails(username, password);
        //request.getRequestDispatcher("index.jsp").forward(request, response);
        if (user != null) {
            Employee emp = EmployeeDao.getUserDetails(username);
            Department dept = DepartmentDao.getDepartmentById(emp);
            
            if (user.getUserType().name().equals(userType)) {
            	if (user.getUserType() == Role.EMPLOYEE) {
                    session.setAttribute("username", username);
                    session.setAttribute("employee", emp);
                    request.setAttribute("department", dept);
                    //response.sendRedirect("views/Employee/index.jsp");
                    response.sendRedirect("DashboardController");
                } else if (user.getUserType() == Role.MANAGER) {
                    session.setAttribute("username", username);
                    session.setAttribute("employee", emp);
                    request.setAttribute("department", dept);
                    response.sendRedirect("ManagerDashboardController");
                } 
            } else {
                response.sendRedirect("index.jsp");
            }
        } else {
        	
            request.setAttribute("errorMessage", "Invalid username or password or userType");
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
