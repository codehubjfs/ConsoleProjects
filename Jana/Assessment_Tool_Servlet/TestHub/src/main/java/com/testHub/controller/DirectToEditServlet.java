package com.testHub.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.testHub.bean.Question;
import com.testHub.dao.QuestionDAO;

/**
 * Servlet implementation class DirectToEditServlet
 */
public class DirectToEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DirectToEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int aid=0;
    	String aidStr = request.getParameter("aId");
        

        if (aidStr == null || aidStr.isEmpty()) {
            aid = (int) (request.getAttribute("aid")); 
        }
        else {

        aid = Integer.parseInt(aidStr);
        
        }
        
        String aName = request.getParameter("aName");
        System.out.println(aid+aName);

        QuestionDAO questionDAO = new QuestionDAO();
        List<Question> allQuestions = questionDAO.getAllQuestions();

        
        List<Question> assessmentQuestions = questionDAO.getQuestionsByAssessmentId(aid);
        // Create a set of assigned question IDs
        Set<Integer> assignedQuestionIds = assessmentQuestions.stream()
                                                              .map(Question::getQid)
                                                              .collect(Collectors.toSet());

        // Filter out the assigned questions
        List<Question> unassignedQuestions = allQuestions.stream()
                                                         .filter(question -> !assignedQuestionIds.contains(question.getQid()))
                                                         .collect(Collectors.toList());

        request.setAttribute("questions", unassignedQuestions);
        request.setAttribute("assessmentQuestions", assessmentQuestions);
        request.setAttribute("aName", aName);
        request.setAttribute("aid", aid);
//        request.setAttribute("assessment", new Assessment(aid, request.getParameter("courseName")));

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/Teacher/assessmentQuestions.jsp");
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
