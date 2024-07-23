package com.issueraisesystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.issueraisesystem.beans.Issue;
import com.issueraisesystem.beans.SupervisorDetails;
import com.issueraisesystem.beans.WardenDetails;
import com.issueraisesystem.dao.IssueDAO;
import com.issueraisesystem.dao.SupervisorDAO;
import com.issueraisesystem.dao.WardenDAO;

/**
 * Servlet implementation class ManageTicketController
 */
public class ManageTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageTicketController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
        String mailid=(String) request.getSession().getAttribute("mailid");
        
        if (mailid == null) {
			
            // Handle case where username is not found in session, perhaps redirect to login
			request.getRequestDispatcher("//logout").forward(request, response);
            return;
        }
        
        try {
			List<Issue> tickets = new IssueDAO().totalIssue();
			
			List<Issue>raiseticket=tickets.stream().filter(x->x.getStatus().equals("Raised")).collect(Collectors.toList());
			
			request.setAttribute("NewTicket", raiseticket);

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        
        
        SupervisorDAO supervisorDao=new SupervisorDAO();
        
        try {
			List<SupervisorDetails>supervisors=supervisorDao.getAllSupervisor();
			request.setAttribute("supervisors", supervisors);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        
        
        WardenDAO wardenDAO=new WardenDAO();
        try {
        	
        	
        	List<WardenDetails>profile=wardenDAO.profileOverview(mailid);
        	
        	
        	request.setAttribute("ProfileOverview", profile);
        	
        	 request.getRequestDispatcher("/views/warden/ManageTicket.jsp").forward(request, response);
        }
        catch(Exception e) {
        	System.out.println(e.getMessage());
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
