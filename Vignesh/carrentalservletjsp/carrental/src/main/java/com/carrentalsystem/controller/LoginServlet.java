package com.carrentalsystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.carrentalsystem.beans.Login;
import com.carrentalsystem.dao.LoginDao;

//@WebServlet("/loginS")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("username");
        String password = request.getParameter("password");
        Login user = new Login();
        user.setUserName(email);
        user.setPassword(password);
        LoginDao log = new LoginDao();
        boolean result = false;

        try {
            result = log.validateLogin(user);
            if (result) {
            	HttpSession session = request.getSession();
            	session.setAttribute("email", email);                // Successful login
                response.sendRedirect(request.getContextPath() + "/views/admin/index.jsp");
            } else {
                // Failed login
                String errorMessage = "Invalid username or password. Please try again.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("/views/admin/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
