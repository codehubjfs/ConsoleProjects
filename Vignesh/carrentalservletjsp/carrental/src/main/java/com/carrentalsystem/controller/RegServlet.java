package com.carrentalsystem.controller;

import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.carrentalsystem.beans.User;
import com.carrentalsystem.dao.RegDao;

@WebServlet("/register")
public class RegServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RegDao userDAO;

    public void init() {
        userDAO = new RegDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String emailId= (String) request.getSession().getAttribute("email");
        if (emailId == null) {
		         
			request.getRequestDispatcher("//logout").forward(request, response);
           return;
       }
    	System.out.println("hi");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setGender(gender);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);
        
        user.setUsername(username);
        try {
            userDAO.insertUser(user);
            response.sendRedirect("views/user/index.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }

       
    }
}
