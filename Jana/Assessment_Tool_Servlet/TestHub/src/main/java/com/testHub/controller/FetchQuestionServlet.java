package com.testHub.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.testHub.bean.Question;
import com.testHub.dao.QuestionDAO;

/**
 * Servlet implementation class FetchQuestionServlet
 */
public class FetchQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
		       // Fetch questions from the database
		String assessmentName = request.getParameter("AssessmentName");
		QuestionDAO questionDAO = new QuestionDAO();
        List<Question> questions = questionDAO.getQuestionsByAssessmentId(assessmentId);

        // Set the questions as a request attribute
        request.setAttribute("questions", questions);
        request.getSession().setAttribute("assessmentId", assessmentId);
        request.setAttribute("assessmentName", assessmentName);

        // Forward to test.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/Student/test.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
