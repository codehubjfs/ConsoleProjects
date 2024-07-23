package com.testHub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.testHub.bean.Assessment;
import com.testHub.dao.AssessmentDAO;

/**
 * Servlet implementation class AddAssessmentServlet
 */
public class AddAssessmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAssessmentServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		int courseId = Integer.parseInt(request.getParameter("cid"));
		String courseName = request.getParameter("courseName");
		request.setAttribute("courseId", courseId);
		request.setAttribute("courseName", courseName);
		String aName = request.getParameter("aName");
        String stTime = request.getParameter("stTime");
        String endTime = request.getParameter("endTime");
        int duration = Integer.parseInt(request.getParameter("duration"));
        int totMarks = Integer.parseInt(request.getParameter("totMarks"));
        int cid = Integer.parseInt(request.getParameter("cid"));
        String aDateStr = request.getParameter("aDate");
        int eid = Integer.parseInt(request.getParameter("eid"));
        
        // Convert the date string to LocalDate
        LocalDate aDate = LocalDate.parse(aDateStr, DateTimeFormatter.ISO_DATE);

        Assessment assessment = new Assessment();
        assessment.setaName(aName);
        assessment.setStTime(stTime);
        assessment.setEndTime(endTime);
        assessment.setDuration(duration);
        assessment.setTot_marks(totMarks);
        assessment.setCid(cid);
        assessment.setaDate(aDate);
        assessment.setEid(eid);

        AssessmentDAO assessmentDAO = new AssessmentDAO();
        boolean isAdded = assessmentDAO.addAssessment(assessment);

        if (isAdded) {
            response.sendRedirect("TeacherAssessmentServlet");
        } 
    
	}

}
