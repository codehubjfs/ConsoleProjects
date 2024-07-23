package com.hotelmanagement.controller;

import java.io.IOException;
import com.hotelmanagement.bean.LoginUser;
import com.hotelmanagement.dao.LoginUserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebServlet("/LoginUserServlet")
public class LoginUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        LoginUser log = new LoginUser();
        log.setMail(email);
        log.setPassword(pass);

        LoginUserDao dao = new LoginUserDao();
        boolean result = dao.validate(log);

        boolean hasError = false;
        if (email == null || email.isEmpty()) {
            request.setAttribute("emailError", "Please enter your email.");
            hasError = true;
        }
        if (pass == null || pass.isEmpty()) {
            request.setAttribute("passwordError", "Please enter your password.");
            hasError = true;
        }

        if (hasError) {
        	
            request.getRequestDispatcher("views/user/login.jsp").forward(request, response);
            return;
        }

        if (result) {
        	HttpSession session = request.getSession();
        	session.setAttribute("user", email);
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid email or password.");
            request.getRequestDispatcher("views/user/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
}
