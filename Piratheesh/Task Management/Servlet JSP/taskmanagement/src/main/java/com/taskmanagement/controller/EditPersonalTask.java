package com.taskmanagement.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import com.taskmanagement.beans.EditPersonalTaskBeans;
import com.taskmanagement.dao.PersonalTaskDAO;

/**
 * Servlet implementation class EditPersonalTask
 */
//@WebServlet("/EditPersonalTask")
public class EditPersonalTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPersonalTask() {
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
		    int taskId = Integer.parseInt(request.getParameter("editTaskId"));
		    String taskName = request.getParameter("editTaskName");
	        String desp = request.getParameter("editTaskDescription");
	        LocalDate startDate = LocalDate.parse(request.getParameter("editStartDate"));
	        LocalDate endDate = LocalDate.parse(request.getParameter("editEndDate"));
	        String priority = request.getParameter("editTaskPriority");
	        
	        EditPersonalTaskBeans personalTaskEdit = new EditPersonalTaskBeans();
	        personalTaskEdit.setTask_id(taskId);
	        personalTaskEdit.setTask_name(taskName);
	        personalTaskEdit.setDesp(desp);
	        personalTaskEdit.setPriority(priority);
	        personalTaskEdit.setStart_date(startDate);
	        personalTaskEdit.setEnd_date(endDate);
//	        
//	        System.out.println("Task Name: " + taskName);
//	        System.out.println("Description: " + desp);
//	        System.out.println("Start Date: " + startDate);
//	        System.out.println("End Date: " + endDate);
//	        System.out.println("Priority: " + priority);
	        
	        PersonalTaskDAO personalDAO = new PersonalTaskDAO();
	        
	        try {
	            personalDAO.updatePersonalTask(personalTaskEdit);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        request.getRequestDispatcher("PersonalTask").forward(request, response);
	}

}
