package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import bean.AdminBean;
import bean.Customer;
import bean.RoutesBean;
import dao.AdminDao;
import dao.CustomerDao;
import dao.RouteDao;

/**
 * Servlet implementation class CardController
 */

public class CardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RouteDao routeDao;
	CustomerDao customerDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		routeDao=new RouteDao();
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
		 RouteDao routeDao = new RouteDao();
		 HttpSession session = request.getSession(false); 
		 request.getSession().getAttribute("customer");
		 System.out.println((AdminBean)request.getSession().getAttribute("customer"));
		 AdminBean admin=(AdminBean)request.getSession().getAttribute("customer");
		 request.setAttribute("customer", admin);
	        List<RoutesBean> routes = routeDao.getAllRoutes();
	        if (routes != null) {
	            int routeSize = routes.size();
	            System.out.println("Number of routes: " + routeSize); 
	            request.setAttribute("Routes", routeSize);
	        } 
	        List<Customer> customer=customerDao.viewCustomer();
	        int customerSize=customer.size();
	        System.out.println("Number of Customer: "+customerSize);
	        request.setAttribute("Customers", customerSize);
//	        List<Bus> bus=BusDao.viewBus();
//	        int totalBus=bus.size();
//	        System.out.println("Number of Bus: "+totalBus);
//	        List<Booking> booking=bookDao.viewBooking();
//	        int totalBook=booking.size();
//	        System.out.println("Number of Booking: "+totalBook);
	        if (session != null && session.getAttribute("customer") != null) {
	        request.getRequestDispatcher("/view/Admin/AdminIndex.jsp").forward(request, response);
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
