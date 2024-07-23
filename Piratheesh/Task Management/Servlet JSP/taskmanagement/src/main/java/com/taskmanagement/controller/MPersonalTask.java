package com.taskmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import com.taskmanagement.beans.PersonalTaskBeans;
import com.taskmanagement.dao.PersonalTaskDAO;

/**
 * Servlet implementation class PersonalTask
 */
public class MPersonalTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MPersonalTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("employeeMail");
		
		PersonalTaskDAO personalDAO = new PersonalTaskDAO();
		
		List<PersonalTaskBeans> personalTask = personalDAO.selectAllPersonalTasks(email);
		
		
		request.setAttribute("personalTasks", personalTask);
		
		request.getRequestDispatcher("views/Manager/personaltask.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
