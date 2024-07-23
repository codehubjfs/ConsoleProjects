package com.testHub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class TestToHomeServlet
 */
public class TestToHomeServlet extends                                      HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestToHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email =   (String) request.getSession().getAttribute("email");
		String password = (String) request.getSession().getAttribute("password");
		String userType = (String) request.getSession().getAttribute("userType");
		
		request.setAttribute("email", email);
		request.setAttribute("password", password);
		request.setAttribute("userType", userType);
		
		System.out.println(email+" "+password+" "+userType);
		
		request.getRequestDispatcher("LoginAuthentication").forward(request, response);
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
