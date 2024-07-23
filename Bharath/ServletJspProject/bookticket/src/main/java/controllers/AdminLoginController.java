package controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import bean.AdminBean;
import dao.AdminDao;


/**
 * Servlet implementation class AdminLoginController
 */
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 AdminDao adminDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		adminDao = new AdminDao();
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("helllo");
		 String email = request.getParameter("ems");
		 System.out.println(email);
	       String password = request.getParameter("psw");
	       System.out.println(password);
	      
	       AdminBean customer;
		try {
			customer = adminDao.login(email, password);
			  System.out.println("helllo");
		       if (customer != null) {
		    	   System.out.println("loginsuccessfully");
		    	   HttpSession session = request.getSession();
		           request.getSession().setAttribute("customer", customer);
		           response.sendRedirect(request.getContextPath() + "/CardController");
		       } else {
		    	   System.out.println("invalid");
		           request.setAttribute("error", "Invalid email or password.");
		           request.getRequestDispatcher("/view/Admin/LoginError.jsp").forward(request, response);
		       }
		   
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
