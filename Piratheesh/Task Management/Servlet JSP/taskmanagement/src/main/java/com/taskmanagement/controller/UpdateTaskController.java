package com.taskmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.taskmanagement.beans.UpdateTask;
import com.taskmanagement.dao.TaskDao;

/**
 * Servlet implementation class UpdateTaskController
 */
public class UpdateTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTaskController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		int emp_id = (int) session.getAttribute("employeeId");
		String status = request.getParameter("status");
		int status_id=0;
		int task =Integer.parseInt(request.getParameter("task_id"));
		System.out.println(emp_id);
		switch(status) {
		case "assigned":
			status_id=1;
			break;
			
		case "pending":
			status_id=3;
			break;
			
		case "completed":
			status_id=4;
			break;
			
		case "overlayed":
			status_id=5;
			break;
			
		}
		
		UpdateTask updatetask = new UpdateTask();
		updatetask.setEmp_id(emp_id);
		updatetask.setTask_status(status_id);
		updatetask.setTask_id(task);
		
		TaskDao tasks = new TaskDao();
		
		try {
			tasks.updateTasks(updatetask);
		}catch (Exception e) {
            e.printStackTrace();
        }
		
		request.getRequestDispatcher("AssignedTask").forward(request, response);
	}

}
