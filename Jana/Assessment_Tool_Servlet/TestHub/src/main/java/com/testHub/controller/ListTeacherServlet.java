package com.testHub.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.testHub.bean.Educator;
import com.testHub.dao.TeacherDAO;

/**
 * Servlet implementation class ListTeacherServlet
 */
public class ListTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TeacherDAO teacherDao;
	
	public void init() {
	teacherDao = new TeacherDAO();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("reached dServ");
		listTeacher(request,response);
	}
	
	private void listTeacher(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		System.out.println("reached dmethod");
        List<Educator> listTeacher = teacherDao.selectAllTeachers();
        request.getSession().setAttribute("listTeacher", listTeacher);
        System.out.println("got list");
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/Admin/admin.jsp");
        dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
