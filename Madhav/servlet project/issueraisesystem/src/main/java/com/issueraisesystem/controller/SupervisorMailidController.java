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

import com.google.gson.Gson;
import com.issueraisesystem.beans.StudentDetails;
import com.issueraisesystem.beans.SupervisorDetails;
import com.issueraisesystem.dao.StudentDAO;
import com.issueraisesystem.dao.SupervisorDAO;

/**
 * Servlet implementation class SupervisorMailidController
 */


public class SupervisorMailidController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupervisorMailidController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SupervisorDAO supervisorDao=new SupervisorDAO();
		System.out.println("supercl");
		List<SupervisorDetails> list=null;
		try {
			list = supervisorDao.getAllSupervisor();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> mail = (List<String>) list.stream()
				.map(c->c.getMailid())
				.collect(Collectors.toList());
		 String json = new Gson().toJson(mail);
	     response.setContentType("application/json");
	     response.setCharacterEncoding("UTF-8");
	     response.getWriter().write(json);
	     
	     
	}

}
