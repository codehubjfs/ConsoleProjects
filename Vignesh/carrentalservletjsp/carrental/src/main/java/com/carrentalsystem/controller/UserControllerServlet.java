package com.carrentalsystem.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.carrentalsystem.beans.User;
import com.carrentalsystem.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;




public class UserControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDao userDAO;

    public UserControllerServlet() {
        
    }

    public void init() throws ServletException {
       
        userDAO = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String email= (String) request.getSession().getAttribute("email");
        if (email == null) {
		         
			request.getRequestDispatcher("//logout").forward(request, response);
           return;
       }
    	System.out.println("hi1");
        List<User> userList;
		try {
			userList = userDAO.getAllUsers();
			 request.setAttribute("userList", userList);
		        request.getRequestDispatcher("views/admin/usermanagement.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("hi2");
       
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
