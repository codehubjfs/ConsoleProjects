package com.hotelmanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.hotelmanagement.bean.Keeper;
import com.hotelmanagement.dao.KeeperDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListKeeperServlet
 */
public class ListKeeperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  private KeeperDao keeperDao;
	    
	    public void init() {
	        keeperDao = new KeeperDao();
	    }
    public ListKeeperServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0");
        
        if(request.getSession().getAttribute("username")==null)
        {
        	response.sendRedirect("LogoutAdminServlet");
        }
		
		
		
		
        if(request.getSession().getAttribute("username")!=null)
        {
        	try {
		        List<Keeper> keepers = keeperDao.getAllHousekeepers();
		        request.setAttribute("keepers", keepers); // Set the 'keepers' attribute in request scope
		        request.getRequestDispatcher("/views/admin/keeper.jsp").forward(request, response); // Forward to keeper.jsp
		    } catch (SQLException e) {
		        e.printStackTrace();
		        throw new ServletException("Error retrieving housekeepers", e);
		    }
        }
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
