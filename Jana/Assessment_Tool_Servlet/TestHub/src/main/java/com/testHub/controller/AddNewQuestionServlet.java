package com.testHub.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.testHub.bean.Question;
import com.testHub.dao.QuestionDAO;

/**
 * Servlet implementation class AddNewQuestion
 */
public class AddNewQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionDAO questionDAO = new QuestionDAO();
		Question question = new Question();
		question.setQuestions(request.getParameter("questionText"));
		question.setC1(request.getParameter("option1"));
		question.setC2(request.getParameter("option2"));
		question.setC3(request.getParameter("option3"));
		question.setC4(request.getParameter("option4"));
		question.setAnswer(request.getParameter("correctAnswer"));
		question.setMark(Integer.parseInt(request.getParameter("mark")));
		int qid=questionDAO.addNewQuestion(question);
		int aid = Integer.parseInt(request.getParameter("aid"));
		request.setAttribute("aid", aid);
		request.setAttribute("qid", qid);
		RequestDispatcher rd = request.getRequestDispatcher("AddQuestionToAssessmentServlet");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
