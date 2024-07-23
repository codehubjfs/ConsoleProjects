package com.issueraisesystem.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.issueraisesystem.beans.StudentDetails;
import com.issueraisesystem.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditProfile
 */

@WebServlet("/studenteditprofile")
public class EditProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EditProfileController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String mailid= (String) request.getSession().getAttribute("mailid");
		if (mailid == null) {
			
            // Handle case where username is not found in session, perhaps redirect to login
			request.getRequestDispatcher("//logout").forward(request, response);
            return;
        }
		
		String editname=request.getParameter("editname");
		
		String editnumber=request.getParameter("editnumber");
		
		
		StudentDetails student=new StudentDetails();
		
		
		student.setPhonenumber(editnumber);
		student.setName(editname);
		
		StudentDAO studentDao=new StudentDAO();
		try {
			studentDao.editProfile(student,mailid);
			request.getRequestDispatcher("/Sdashboard").forward(request, response);
			
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
