package com.testHub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.testHub.bean.Question;
import com.testHub.bean.QuestionAnalytics;
import com.testHub.bean.Result;
import com.testHub.dao.QuestionDAO;
import com.testHub.dao.ResultDAO;

/**
 * Servlet implementation class ViewResultsServlet
 */

public class ViewResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ResultDAO resultDAO;

    public void init() {
        resultDAO = new ResultDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
        List<Result> results = resultDAO.getResultsByAssessmentId(assessmentId);
        List<QuestionAnalytics> questions = resultDAO.getQuestionsByAssessmentId(assessmentId);
        QuestionDAO questionDAO = new QuestionDAO();
        List<Question> allquestions = questionDAO.getQuestionsByAssessmentId(assessmentId);

        for (Result result : results) {
            Map<Integer, String> studentAnswers = resultDAO.getStudentAnswers(result.getStudentId(), assessmentId);
            result.setStudentAnswers(studentAnswers);
        }

        request.setAttribute("results", results);
        request.setAttribute("questions", questions);
        request.setAttribute("allquestions", allquestions);
        request.setAttribute("assessmentId", assessmentId);
        request.getRequestDispatcher("views/Teacher/viewResults.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
