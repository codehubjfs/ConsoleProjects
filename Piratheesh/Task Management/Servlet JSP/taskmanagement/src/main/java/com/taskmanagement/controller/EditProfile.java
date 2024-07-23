package com.taskmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.taskmanagement.beans.EditProfileBeans;
import com.taskmanagement.dao.EmployeeDAO;

/**
 * Servlet implementation class EditProfile
 */
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfile() {
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
		String email = (String) session.getAttribute("employeeMail");
		String city = request.getParameter("city");
		String Phone = request.getParameter("phonenumber");
		
		EditProfileBeans editProfile = new EditProfileBeans();
		editProfile.setEmail(email);
		editProfile.setPhone(Phone);
		editProfile.setCity(city);
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		try {
			employeeDAO.updateProfile(editProfile);
		}catch (Exception e) {
            e.printStackTrace();
        }
		
		request.getRequestDispatcher("EmployeeDashBoard").forward(request, response);
	}

}
