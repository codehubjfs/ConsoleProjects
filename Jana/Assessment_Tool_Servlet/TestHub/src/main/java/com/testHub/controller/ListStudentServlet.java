package com.testHub.controller;

import java.io.IOException;
import java.util.List;

import com.testHub.bean.Student;
import com.testHub.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ListStudentServlet
 */
public class ListStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;
	
	public void init() {
        studentDao = new StudentDao();
    }

    /**
     * Default constructor. 
     */
    public ListStudentServlet() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println("reached ListServ");
		listStudent(request, response);
	}
	
	private void listStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> listStudent = studentDao.selectAllStudents();
        request.getSession().setAttribute("listStudent", listStudent);
        System.out.println("got list");
        response.sendRedirect("ListTeacherServlet");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("views/Admin/admin.jsp");
//        dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
