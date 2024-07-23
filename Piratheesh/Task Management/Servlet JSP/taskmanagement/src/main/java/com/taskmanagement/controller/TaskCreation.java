package com.taskmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

import com.taskmanagement.beans.TaskBeans;
import com.taskmanagement.dao.TaskDao;

/**
 * Servlet implementation class TaskCreation
 */
public class TaskCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskCreation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String taskName = request.getParameter("taskName");
		String desp = request.getParameter("desp");
		String priority = request.getParameter("priority");
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
        
        System.out.println(taskName);
        System.out.println(desp);
        System.out.println(startDate);
        
        TaskBeans task = new TaskBeans();
        task.setTask_name(taskName);
        task.setDesp(desp);
        task.setPriority(priority);
        task.setStart_date(startDate);
        task.setEnd_date(endDate);
        
        TaskDao taskdao = new TaskDao();
        
        try {
        	taskdao.insertTask(task);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		request.getRequestDispatcher("TaskManage").forward(request, response);
		
	}

}
