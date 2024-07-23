package com.carrentalsystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.carrentalsystem.beans.CarTemp;
import com.carrentalsystem.beans.User;
import com.carrentalsystem.dao.AdminCarDao;
import com.carrentalsystem.dao.CarTempDao;
import com.carrentalsystem.dao.UserDao;

/**
 * Servlet implementation class AdminDashboardServlet
 */
public class AdminDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminCarDao cartempdao;
	public void init(){
		cartempdao=new AdminCarDao();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDashboardServlet() {
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email= (String) request.getSession().getAttribute("email");
         if (email == null) {
		         
			request.getRequestDispatcher("//logout").forward(request, response);
            return;
        }
		
		CarTempDao car = new CarTempDao();
		UserDao UserDao = new UserDao();
		System.out.print("yen varala");
        List<CarTemp> listCars;
        List<User> userList ;
			try {
				userList = UserDao.getAll();
				 request.setAttribute("userList", userList.size());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		try {
			listCars = AdminCarDao.listCars();
			request.setAttribute("listCarSize", listCars.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        System.out.println("got list");
    request.getRequestDispatcher("views/admin/index.jsp").forward(request, response);
	}
		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
