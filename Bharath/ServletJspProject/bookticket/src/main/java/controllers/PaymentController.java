package controllers;

import java.io.IOException;
import java.util.Arrays;

import bean.BookingBean;
import bean.Bus;
import bean.PassengerBean;
import bean.RoutesBean;
import dao.BusesDao;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class PaymentController
 */
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PaymentController() {
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
//		  String[] selectedSeats = request.getParameterValues("selectedSeats");
//	        int busId = Integer.parseInt(request.getParameter("busid"));
//	        int routeId = Integer.parseInt(request.getParameter("routeid"));
//	        String phoneNumber = request.getParameter("mobileNumber");
//	        String email = request.getParameter("emailAddress");
//	        if (selectedSeats != null) {
//	            HttpSession session = request.getSession();
//
//	            for (String seat : selectedSeats) {
//	                String passengerName = request.getParameter("passengerName" + seat);
//	                int age = Integer.parseInt(request.getParameter("age" + seat));
//	                String gender = request.getParameter("gender" + seat);
//	                PassengerBean passenger = new PassengerBean();
//	                passenger.setName(passengerName);
//	                passenger.setAge(age);
//	                passenger.setGender(gender);
//	                passenger.setEmail(email);
//	                passenger.setPhoneNumber(phoneNumber);
//
//	                session.setAttribute("passenger" + seat, passenger); // Store each passenger uniquely by seat number
//
//	            }
//	        }
		String upi=request.getParameter("upinumber");
		
		response.sendRedirect(request.getContextPath() + "/bookingConfirmation.jsp");
	    }
	   
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
