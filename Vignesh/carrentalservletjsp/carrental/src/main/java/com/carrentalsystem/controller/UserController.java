package com.carrentalsystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.carrentalsystem.beans.User;
import com.carrentalsystem.dao.UserDao;
import com.carrentalsystem.dao.UsersDao;


public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsersDao userDao;

    public void init() {
        userDao = new UsersDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession(false);
    	String action = request.getParameter("action");
        if ("edit".equals(action)) {
            editUser(request, response);
        } else if ("delete".equals(action)) {
            deleteUser(request, response);
        }
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	String email= (String) request.getSession().getAttribute("email");
        if (email == null) {
		         
			request.getRequestDispatcher("//logout").forward(request, response);
           return;
       }
    	int userId = Integer.parseInt(request.getParameter("userId"));
        String accountStatus = request.getParameter("accountStatus");
        System.out.println("editi");
        User user = new User();
        user.setUserId(userId);
        user.setAccountStatus(accountStatus);        
        userDao.updateUser(user);
        response.sendRedirect("UserControllerServlet");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	HttpSession session = request.getSession(false);
    	int userId = Integer.parseInt(request.getParameter("userId"));
        System.out.println("deleti");
        userDao.deleteUser(userId);
        response.sendRedirect("UserControllerServlet");
    }
}

