package com.testHub.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.testHub.bean.Assessment;
import com.testHub.bean.Question;
import com.testHub.dao.AssessmentScoreDAO;


public class AssessmentScoreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
//        String assessmentName = request.getParameter("AssessmentName");

        // Fetch assessment data
        AssessmentScoreDAO assessmentScoreDAO = new AssessmentScoreDAO();
        Assessment assessment = assessmentScoreDAO.fetchAssessmentData(assessmentId);

        
        List<Question> questions = assessmentScoreDAO.fetchQuestions(assessmentId);

        
        Map<Integer, String> correctAnswers = assessmentScoreDAO.fetchCorrectAnswers(assessmentId);
        Map<Integer, String> studentAnswers = assessmentScoreDAO.fetchStudentAnswers(request.getSession().getAttribute("sid"), assessmentId);

        
        int totalScore = assessmentScoreDAO.fetchTotalScore(request.getSession().getAttribute("sid"), assessmentId);

        // Set attributes
        request.setAttribute("assessment", assessment);
        request.setAttribute("questions", questions);
        request.setAttribute("correctAnswers", correctAnswers);
        request.setAttribute("studentAnswers", studentAnswers);
        request.setAttribute("totalScore", totalScore);

        // Forward to JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Student/displayScore.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
