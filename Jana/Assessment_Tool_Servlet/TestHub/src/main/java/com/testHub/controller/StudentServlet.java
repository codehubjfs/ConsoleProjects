package com.testHub.controller;




/**
 * Servlet implementation class StudentServlet
 */
import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.testHub.bean.Student;
import com.testHub.dao.StudentDao;

public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDao studentDao;

    public void init() {
        studentDao = new StudentDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/insert":
                try {
                    insertStudent(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "/list":
                listStudent(request, response);
                break;
            default:
                listStudent(request, response);
                break;
        }
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        Student newStudent = new Student();
        newStudent.setEmail(email);
        newStudent.setPassword(password);
        newStudent.setFname(fname);
        newStudent.setLname(lname);
        newStudent.setCity(city);
        newStudent.setCountry(country);
        studentDao.insertStudent(newStudent);
        response.sendRedirect("list");
    }
    
    private void listStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> listStudent = studentDao.selectAllStudents();
        request.setAttribute("listStudent", listStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
        dispatcher.forward(request, response);
    }
}