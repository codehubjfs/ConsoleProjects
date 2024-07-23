package com.issueraisesystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.issueraisesystem.beans.Issue;
import com.issueraisesystem.beans.StudentDetails;
import com.issueraisesystem.dao.IssueDAO;
import com.issueraisesystem.dao.StudentDAO;

/**
 * Servlet implementation class TicketRaiseController
 */

@WebServlet("/tickeraise")
public class TicketRaiseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketRaiseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String mailid=(String) request.getSession().getAttribute("mailid");
		 try {
	        	
	        	StudentDAO student=new StudentDAO();
	        	List<StudentDetails>profile=student.profileOverview(mailid);
	        	request.setAttribute("ProfileOverview", profile);
	        	
	        	
	        }
	        catch(Exception e) {
	        	System.out.println(e.getMessage());
	        }
		
		if (mailid == null) {
			
            // Handle case where username is not found in session, perhaps redirect to login
			request.getRequestDispatcher("//logout").forward(request, response);
            return;
        }
		
		 
		try {
			List<Issue> tickets = new IssueDAO().getTicketsByUsername(mailid);
            request.setAttribute("tickets", tickets);
            request.getRequestDispatcher("/views/Student/ticketraise.jsp").forward(request, response);
            
        } catch (SQLException e) {
            e.getMessage();
            // Handle database error
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
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
