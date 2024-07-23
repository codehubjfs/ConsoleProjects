package com.testHub.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.testHub.dao.QuestionDAO;

/**
 * Servlet implementation class AddQuestionToAssessmentServlet
 */
public class AddQuestionToAssessmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestionToAssessmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int aid=0;
    	int qid=0;
    	String aidStr = request.getParameter("aid");
    	String qidStr = request.getParameter("qid");

        if (aidStr == null || aidStr.isEmpty() || qidStr == null || qidStr.isEmpty()) {
            aid = (int) (request.getAttribute("aid"));
            qid = (int) (request.getAttribute("qid"));
        }
        else {

        aid = Integer.parseInt(aidStr);
        qid = Integer.parseInt(qidStr);
        }


        QuestionDAO questionDAO = new QuestionDAO();
        int n = questionDAO.assignQuestion(aid, qid);
        request.setAttribute("aid", aid);
		request.setAttribute("qid", qid);
        if (n == 1) {
            RequestDispatcher rd = request.getRequestDispatcher("DirectToEditServlet");
            rd.forward(request, response);
        } else {
            // Handle the failure case
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to assign question");
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
