package com.taskmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.taskmanagement.beans.TaskBeans;
import com.taskmanagement.dao.TaskDao;

/**
 * Servlet implementation class TaskManage
 */
public class TaskManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String mail= (String)session.getAttribute("employeeMail");
		
		TaskDao taskdao = new TaskDao();
		
		List<TaskBeans> task = taskdao.selectAllTasks();
		List<TaskBeans> ft = task.stream().filter((t)->t.getEnd_date().isAfter(LocalDate.now())).collect(Collectors.toList());
		
		request.setAttribute("task", ft);
		
		System.out.println(ft);
		
		request.getRequestDispatcher("views/Manager/taskmanage.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
