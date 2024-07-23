package com.issueraisesystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.issueraisesystem.beans.StudentDetails;
import com.issueraisesystem.beans.SupervisorDetails;
import com.issueraisesystem.dao.StudentDAO;

/**
 * Servlet implementation class StudentController
 */

@WebServlet("/studentdashboard")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mailid=(String) request.getSession().getAttribute("mailid");
		
		if (mailid == null) {
			
            // Handle case where username is not found in session, perhaps redirect to login
			request.getRequestDispatcher("//logout").forward(request, response);
            return;
        }
		 try {
	        	
	        	StudentDAO student=new StudentDAO();
	        	List<StudentDetails>profile=student.profileOverview(mailid);
	        	request.setAttribute("ProfileOverview", profile);
	        	
	        	
	        }
	        catch(Exception e) {
	        	System.out.println(e.getMessage());
	        }
		StudentDAO studentDao=new StudentDAO();
		try {
			
			List<StudentDetails>studentDetails=studentDao.getAllStudent();
			request.setAttribute("studentdetails",studentDetails);
			request.getRequestDispatcher("/views/Student/studentable.jsp").forward(request, response);
			
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
