package controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import bean.RoutesBean;
import dao.RouteDao;

/**
 * Servlet implementation class ViewRoutesController
 */
public class ViewRoutesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 private RouteDao routeDao;
    public ViewRoutesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		routeDao = new RouteDao();
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
	        List<RoutesBean> routes = routeDao.getAllRoutes();
	        HttpSession session = request.getSession(false); 
	        for (RoutesBean route : routes) {
	            System.out.println(route.getIndex() + " " + route.getSource() + " " + route.getDistance() + " " + route.getDuration());
	        }
	        request.setAttribute("routes", routes);
	        if (session != null && session.getAttribute("customer") != null) {
	        	 request.getRequestDispatcher("view/Admin/Routes.jsp").forward(request, response);
		        } 
		        else {
		            // User is not logged in, redirect to the login page
		            response.sendRedirect(request.getContextPath() + "/view/Admin/Login.jsp");
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
