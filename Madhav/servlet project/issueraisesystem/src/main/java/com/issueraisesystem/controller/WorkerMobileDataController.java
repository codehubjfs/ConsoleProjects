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
import com.issueraisesystem.beans.WorkersDetails;
import com.issueraisesystem.dao.WorkersDAO;

/**
 * Servlet implementation class WorkerMobileDataController
 */
public class WorkerMobileDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkerMobileDataController() {
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
		System.out.println("hai");
		WorkersDAO workerDao=new WorkersDAO();
		try {
			List<WorkersDetails>workers=workerDao.getWorkersDetails();
			List<String>mobileNumbers=workers.stream().map(c->String.valueOf(c.getPhonenumber())).collect(Collectors.toList());
			
			String json = new Gson().toJson(mobileNumbers);
		     response.setContentType("application/json");
		     response.setCharacterEncoding("UTF-8");
		     response.getWriter().write(json);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
