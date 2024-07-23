package com.taskmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.taskmanagement.dao.PersonalTaskDAO;
import com.taskmanagement.dao.TaskDao;

/**
 * Servlet implementation class MDeleteTaskPerosnal
 */
public class MDeleteTaskPerosnal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MDeleteTaskPerosnal() {
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
		String mail= (String)session.getAttribute("employeeMail");
        int id = Integer.parseInt(request.getParameter("taskId"));
		
		PersonalTaskDAO task=new PersonalTaskDAO();
		
		try {
			task.deletePersonalTask(id,mail);
		}catch (Exception e) {
            e.printStackTrace();
        }
		request.getRequestDispatcher("MPersonalTask").forward(request, response);
	}

}
