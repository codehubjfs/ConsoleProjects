package com.taskmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.taskmanagement.beans.CompletedBeans;
import com.taskmanagement.dao.CompletedDAO;

//@WebServlet("/CompletedTask")
public class CompletedTask extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CompletedTask() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String email=(String)session.getAttribute("employeeMail");
		
        CompletedDAO completedDAO = new CompletedDAO();
        
        List<CompletedBeans> completedTasks = completedDAO.getCompletedTasks(email);
        
        request.setAttribute("completedTasks", completedTasks);
        
        request.getRequestDispatcher("views/Employee/completedtask.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
