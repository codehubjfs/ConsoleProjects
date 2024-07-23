package com.issueraisesystem.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.issueraisesystem.beans.StudentDetails;
import com.issueraisesystem.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WardenStudentRoomChangeController
 */
public class WardenStudentRoomChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WardenStudentRoomChangeController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int roomno=Integer.parseInt(request.getParameter("roomNo"));
		String blockno=request.getParameter("blockno");
		String mailid=request.getParameter("mailid");
		
		StudentDetails student=new StudentDetails();
		student.setMailid(mailid);
		
		student.setBlockno(blockno);
		student.setRoomno(roomno);
		
		StudentDAO studentDao=new StudentDAO();
		
		try {
			studentDao.editRoom(student);
			request.getRequestDispatcher("/WardenStudentRoomController").forward(request, response);
			
			
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
