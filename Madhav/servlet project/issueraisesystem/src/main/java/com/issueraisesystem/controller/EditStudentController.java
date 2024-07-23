package com.issueraisesystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.issueraisesystem.beans.StudentDetails;
import com.issueraisesystem.dao.StudentDAO;

/**
 * Servlet implementation class EditStudentController
 */
public class EditStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		int roomno=Integer.parseInt(request.getParameter("roomNo"));
		String blockno=request.getParameter("blockno");
		String mailid=request.getParameter("mailid");
		System.out.println(blockno);
		System.out.println(roomno);
		System.out.println(mailid);
		StudentDetails student=new StudentDetails();
		student.setMailid(mailid);
		student.setName(name);
		student.setBlockno(blockno);
		student.setRoomno(roomno);
		
		StudentDAO studentDao=new StudentDAO();
		
		try {
			studentDao.editStudent(student);
			request.getRequestDispatcher("/AdminStudentUserController").forward(request, response);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
