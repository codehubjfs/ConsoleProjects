package com.taskmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

import com.taskmanagement.beans.PersonalTaskAddBeans;
import com.taskmanagement.dao.PersonalTaskDAO;

/**
 * Servlet implementation class PersonalTaskAdd
 */
public class PersonalTaskAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalTaskAdd() {
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
	        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
	        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
	        String priority = request.getParameter("priority");
	        String email = (String) session.getAttribute("employeeMail");
	        
        
        

        PersonalTaskAddBeans personalTask = new PersonalTaskAddBeans();
        personalTask.setTask_name(taskName);
        personalTask.setDesp(desp);
        personalTask.setStart_date(startDate);
        personalTask.setEnd_date(endDate);
        personalTask.setPriority(priority);
        personalTask.setEmail(email);

        PersonalTaskDAO personalDAO = new PersonalTaskDAO();

        try {
            personalDAO.insertPersonalTask(personalTask);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		request.getRequestDispatcher("PersonalTask").forward(request, response);
	}

}
