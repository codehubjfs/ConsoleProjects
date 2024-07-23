package controllers;

import java.io.IOException;

import bean.PassengerBean;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class PassengersController
 */
public class PassengersController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PassengersController() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
		System.out.println("heool");
        String[] selectedSeats = request.getParameterValues("selectedSeats");
        int busId = Integer.parseInt(request.getParameter("busid"));
        int routeId = Integer.parseInt(request.getParameter("routeid"));

        System.out.println(busId + " " + routeId);
        int[] intSeatNumbers = new int[selectedSeats.length];
        System.out.println(selectedSeats.length);
        for(int i=0;i<selectedSeats.length;i++) {
        if (selectedSeats.length != 0) {
          
                String passengerName = request.getParameter("passengerName");
                String age = request.getParameter("age");
                String gender = request.getParameter("gender");
                
                
                System.out.println("Passenger Name: " + passengerName);
                System.out.println("Age: " + age);
                System.out.println("Gender: " + gender);
                System.out.println("--------------------");

                PassengerBean passenger = new PassengerBean();
                passenger.setName(passengerName);
//                passenger.setAge(passengerage);
                passenger.setGender(gender);

                 
            }
        }

        // Retrieve phone number and email address
//        String phoneNumber = request.getParameter("mobileNumber");
//        String email = request.getParameter("emailAddress");
//
//        // Ensure all passengers are updated with phone and email
//        if (selectedSeats != null) {
//            HttpSession session = request.getSession();
//
//            for (String seat : selectedSeats) {
//                PassengerBean passenger = (PassengerBean) session.getAttribute("passenger" + seat);
//                if (passenger != null) {
//                    passenger.setEmail(email);
//                    passenger.setPhoneNumber(phoneNumber);
//                    // Perform further processing (e.g., save passenger details to database)
//                }
//            }
//        }

        // Redirect to a confirmation page or another appropriate page
        response.sendRedirect(request.getContextPath() + "/BookingController");
    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
