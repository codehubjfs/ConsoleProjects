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
import bean.Customer;
import dao.CustomerDao;

/**
 * Servlet implementation class CustomerLoginController
 */
public class CustomerLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CustomerDao customerDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		customerDao=new CustomerDao();
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
		 String email = request.getParameter("email");
		 System.out.println(email);
	       String password = request.getParameter("password");
	       System.out.println(password);
	      
	       Customer customers;
	       
		try {
			customers = customerDao.login(email, password);
			  System.out.println("helllo");
		       if (customers != null) {
		    	   System.out.println("loginsuccessfully");
		    	   HttpSession session = request.getSession();
		           request.getSession().setAttribute("customers", customers);
		           response.sendRedirect(request.getContextPath() + "/view/Customer/Home.jsp");
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
