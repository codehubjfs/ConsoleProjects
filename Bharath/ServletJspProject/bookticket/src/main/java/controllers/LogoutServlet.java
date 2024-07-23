package controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
//		 System.out.println("Hello");
//	        HttpSession session = request.getSession(false); // Do not create a new session if it doesn't exist
//	        if (session != null) {
//	            session.invalidate(); // Invalidate the session
//	        }
//	        response.sendRedirect(request.getContextPath() + "/view/Admin/Login.jsp");
//	    }
		 HttpSession session = request.getSession(false);
	        if (session != null) {
	            if (session.getAttribute("customer") != null) {
	                session.removeAttribute("customer");
	                System.out.println("Admin session invalidated");
	                response.sendRedirect(request.getContextPath() + "/view/Admin/Login.jsp");
	            } else if (session.getAttribute("customers") != null) {
	                session.removeAttribute("customers");
	                System.out.println("Customer session invalidated");
	                response.sendRedirect(request.getContextPath() + "/view/Customer/Login.jsp");
	            }
	            session.invalidate();
	        } 
	        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
	        response.setHeader("Pragma", "no-cache");
	        response.setDateHeader("Expires", 0); 
	 }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
