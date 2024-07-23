package com.testHub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.testHub.bean.Assessment;
import com.testHub.dao.AssessmentDAO;
import com.testHub.dao.StudentMarkDAO;

/**
 * Servlet implementation class AssessmentServlet
 */
public class AssessmentServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AssessmentDAO assessmentDAO;
    private StudentMarkDAO studentMarkDAO;

    @Override
    public void init() {
        assessmentDAO = new AssessmentDAO();
        studentMarkDAO = new StudentMarkDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        int studentId = Integer.parseInt(request.getSession().getAttribute("sid").toString()); // Assuming studentId is stored in session
        String courseName = request.getParameter("courseName");
        request.getSession().setAttribute("courseName", courseName);

        List<Assessment> assessments = assessmentDAO.getAssessmentsByCourseId(courseId);
        List<Integer> completedAssessments = studentMarkDAO.getCompletedAssessments(studentId);

        for (Assessment assessment : assessments) {
            if (completedAssessments.contains(assessment.getAid())) {
                assessment.setStatus("completed");
            } else {
                assessment.setStatus("pending");
            }
        }

        request.setAttribute("assessments", assessments);
        request.getRequestDispatcher("views/Student/assessments.jsp").forward(request, response);
    }
}