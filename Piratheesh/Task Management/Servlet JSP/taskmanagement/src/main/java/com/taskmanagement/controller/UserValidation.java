package com.taskmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import com.taskmanagement.beans.*;
import com.taskmanagement.dao.*;

//@WebServlet("UserValidate")

public class UserValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserValidation() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String Mail = request.getParameter("email");
		String Password = request.getParameter("password");
		String UserType = request.getParameter("usertype");
		
		HttpSession session = request.getSession();
		
		
		PrintWriter out= response.getWriter();
		
		User user=new User();
		user.setEmail(Mail);
		user.setPassword(Password);
		user.setRole(UserType);
		
		session.setAttribute("employeeMail", Mail);
		
		UserLoginDAO log = new UserLoginDAO();
		boolean result=log.validateUserLogin(user);
		
		
		if (result) {
            EmployeeBeans employee = EmployeeDAO.getUserDetails(Mail);
            if (employee != null) {
                String employeeName = employee.getName();
                String phonenumber = employee.getPhoneNumber();
                String role = employee.getRole();
                String city = employee.getCity();
                int emp_id = employee.getEmp_id();
                session.setAttribute("employeeName", employeeName);
                session.setAttribute("employeeNumber", phonenumber);
                session.setAttribute("employeeRole", role);
                session.setAttribute("employeeCity", city);
                session.setAttribute("employeeId", emp_id);
                System.out.println(emp_id);
                switch (UserType) {
                    case "Employee":
                    	
                       response.sendRedirect("EmployeeDashBoard");
//                       response.sendRedirect("views/Employee/dashBoard.jsp");
//                        request.getRequestDispatcher("views/Employee/dashBoard.jsp").forward(request, response);
                        break;

                    case "Manager":
                    	response.sendRedirect("ManagerDashBoard");
//                        request.getRequestDispatcher("views/Manager/dashBoard.jsp").forward(request, response);
                        break;

                    case "Admin":
                    	response.sendRedirect("views/Admin/dashBoard.jsp");
//                        request.getRequestDispatcher("views/Admin/dashBoard.jsp").forward(request, response);
                        break;

                    default:
                        response.sendRedirect("index.jsp");
                        break;
                }
            } else {
                request.setAttribute("errorMessage", "User not found.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "Invalid email or password!!!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
