package com.taskmanagement.controller;

import java.io.IOException;

import com.taskmanagement.beans.EmployeeBeans;
import com.taskmanagement.dao.EmployeeDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getEmployeeDetails")
public class EmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        EmployeeBeans employee = EmployeeDAO.getUserDetails(email);
        
        if (employee != null) {
            request.setAttribute("employee", employee.getName());
            request.setAttribute("Number", employee.getPhoneNumber());
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
