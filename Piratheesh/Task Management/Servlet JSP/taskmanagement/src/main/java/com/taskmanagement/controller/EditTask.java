package com.taskmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import com.taskmanagement.beans.TaskBeans;
import com.taskmanagement.dao.TaskDao;

/**
 * Servlet implementation class AddTask
 */
public class EditTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTask() {
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
		int taskId = Integer.parseInt(request.getParameter("task_id"));
		String taskName = request.getParameter("taskName");
		String desp = request.getParameter("taskDesp");
        LocalDate startDate = LocalDate.parse(request.getParameter("taskStart"));
        LocalDate endDate = LocalDate.parse(request.getParameter("taskEnd"));
        String priority = request.getParameter("status");
        
        TaskBeans task = new TaskBeans();
        task.setTask_id(taskId);
        task.setTask_name(taskName);
        task.setDesp(desp);
        task.setPriority(priority);
        task.setStart_date(startDate);
        task.setEnd_date(endDate);
		
        System.out.println("Task Name: " + taskName);
        System.out.println("Description: " + desp);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Priority: " + priority);
        
        TaskDao taskdao = new TaskDao();
        
        try {
            taskdao.updateTask(task);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        request.getRequestDispatcher("TaskManage").forward(request, response);
	}

}
