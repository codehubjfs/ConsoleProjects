package com.issueraisesystem.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.issueraisesystem.beans.StudentDetails;
import com.issueraisesystem.beans.WardenDetails;
import com.issueraisesystem.dao.StudentDAO;
import com.issueraisesystem.dao.WardenDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WardentMailController
 */
public class WardentMailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WardentMailController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Warden");
		WardenDAO wardenDetails=new WardenDAO();
		
		List<WardenDetails> list=null;
		try {
			list = wardenDetails.getAllWarden();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> mail = (List<String>) list.stream()
				.map(c->String.valueOf(c.getMailid()))
				.collect(Collectors.toList());
		
		mail.forEach(x->System.out.println(x));
		 String json = new Gson().toJson(mail);
	     response.setContentType("application/json");
	     response.setCharacterEncoding("UTF-8");
	     response.getWriter().write(json);
	     
	     
	     
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
