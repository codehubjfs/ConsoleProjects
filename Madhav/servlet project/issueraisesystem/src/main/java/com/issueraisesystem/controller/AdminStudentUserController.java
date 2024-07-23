package com.issueraisesystem.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.issueraisesystem.beans.AdminDetails;
import com.issueraisesystem.beans.StudentDetails;
import com.issueraisesystem.dao.AdminDAO;
import com.issueraisesystem.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminStudentUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AdminStudentUserController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
        
    
        

        AdminDAO adminDao = new AdminDAO();
        List<AdminDetails> adminDetails = null;

        try {
            adminDetails = adminDao.getAdminDetails();
            request.setAttribute("AdminDetails", adminDetails); // Corrected attribute name
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        StudentDAO studentDao = new StudentDAO();

        // Fetch all student details for displaying in the JSP table
        try {
            List<StudentDetails> studentDetails = studentDao.getAllStudent();
            request.setAttribute("studentdetails", studentDetails); // Corrected attribute name
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("views/Admin/usermanagement.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
    	String adminmailid = (String) request.getSession().getAttribute("mailid");
    	if (adminmailid == null) {
            // Handle case where username is not found in session, perhaps redirect to login
            request.getRequestDispatcher("//logout").forward(request, response);
            return;
        }
        String studentName = request.getParameter("studentName");
        String phoneNumber = request.getParameter("phoneNumber");
        String department = request.getParameter("department");
        String block = request.getParameter("block");
        String roomNo = request.getParameter("roomNo");
        String mailid=request.getParameter("mailid");
        String password=request.getParameter("password");
        StudentDAO studentDao = new StudentDAO();

        int room=Integer.parseInt(roomNo);
            StudentDetails student = new StudentDetails();
            student.setName(studentName);
            student.setDepartment(department);
            student.setPhonenumber(phoneNumber);
            student.setBlockno(block);
            student.setRoomno(room);
            student.setMailid(mailid);
            student.setPassword(password);

            try {
                studentDao.addStudent(student);
               doGet(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
    

