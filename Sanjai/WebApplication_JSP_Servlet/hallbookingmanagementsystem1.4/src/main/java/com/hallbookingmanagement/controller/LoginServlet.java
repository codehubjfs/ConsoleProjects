package com.hallbookingmanagement.controller;

import com.hallbookingmanagement.dao.AuthenticationDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.hallbookingmanagement.beans.Customer;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("name");
        String password = request.getParameter("password");
        Customer guest = new Customer();
        guest.setUserName(userName);
        guest.setPassword(password);
        try {
            Customer customer = new AuthenticationDAO().login(guest);
            if (customer == null) {
                request.setAttribute("error", "Invalid Username or Password");
                request.getRequestDispatcher("view/login.jsp").forward(request, response); // Forward to the login page with error
            } else {
            	HttpSession session = request.getSession();
                session.setAttribute("customer", customer);
                request.setAttribute("loginSuccess", true); // Set login success attribute
                request.getRequestDispatcher("view/login.jsp").forward(request, response); // Forward to the login page to show modal
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
