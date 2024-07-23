package com.carrentalsystem.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.carrentalsystem.*;
import com.carrentalsystem.beans.CarTemp;
import com.carrentalsystem.dao.AdminCarDao;





public class AdminListCarServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private AdminCarDao cartempdao;
	public void init(){
		cartempdao=new AdminCarDao();
	}
	public AdminListCarServlet() {
		

}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println("reached ListServ");
		String email= (String) request.getSession().getAttribute("email");
        if (email == null) {
		         
			request.getRequestDispatcher("//logout").forward(request, response);
           return;
       }
		try {
			listCar(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	private void listCar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        List<CarTemp> listCars = AdminCarDao.listCars();
        request.setAttribute("listCar", listCars);
        for(CarTemp c:listCars) {
        	System.out.print(c.getCar_name());
        }
        System.out.println("got list");
    request.getRequestDispatcher("views/admin/carmanagement.jsp").forward(request, response);
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}




    

	


