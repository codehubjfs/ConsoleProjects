package com.testHub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.testHub.dao.CalculateMarkDAO;
import com.testHub.dao.StudentAnswerDAO;

/**
 * Servlet implementation class StoreQuestionServlet
 */
public class StoreQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentAnswerDAO studentAnswerDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	studentAnswerDAO = new StudentAnswerDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("reached SQServ");
		 HttpSession session = request.getSession();
	        Integer studentId = (Integer) session.getAttribute("sid");
	        String answerMapJson = request.getParameter("answerMap");
	        

	        if (studentId == null || answerMapJson == null) {
	            response.sendRedirect("error.jsp");
	            return;
	        }

	        int assessmentId =  (int) session.getAttribute("assessmentId");
	        // Deserialize the JSON into a Map with Integer keys
	        Type type = new TypeToken<Map<String, String>>(){}.getType();
	        Gson gson = new Gson();
	        Map<String, String> stringKeyedMap = gson.fromJson(answerMapJson, type);

	        Map<Integer, String> answers = new HashMap<>();
	        for (Map.Entry<String, String> entry : stringKeyedMap.entrySet()) {
	            answers.put(Integer.parseInt(entry.getKey()), entry.getValue());
	        }

	        try {
	            studentAnswerDAO.saveStudentAnswers(studentId, answers, assessmentId);
	        } catch (SQLException e) {
	            throw new ServletException("Database error", e);
	        }

	        
	        

	        if (studentId == null || assessmentId == 0) {
	            response.sendRedirect("error.jsp");
	            return;
	        }

	        

	        try {
	        	CalculateMarkDAO.calculateAndStoreTotalMarks(studentId, assessmentId);
	            response.sendRedirect("views/Student/thankYou.jsp");
	        } catch (SQLException e) {
	            throw new ServletException("Database error", e);
	        }


	}
}
