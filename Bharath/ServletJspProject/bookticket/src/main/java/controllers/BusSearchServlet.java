package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import bean.Bus;
import bean.BusSearch;
import dao.BusesDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BusSearchServlet
 */
public class BusSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
    public BusSearchServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
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
	    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Running....");
//	     String source = request.getParameter("source");
//       String destination = request.getParameter("destination");
//       String travelDateStr = request.getParameter("travelDate");
//       System.out.println(source + " " + destination + " " + travelDateStr);
//
//			try {
//				 LocalDate travelDate = LocalDate.parse(travelDateStr);
//				 List<Bus> bus= new BusesDao().busList().stream().filter(x->x.getRoute().getSource().equals(source)&& x.getRoute().getDestination().equals(destination) && x.getDateOfBus().equals(travelDate)).collect(Collectors.toList());
//				 request.setAttribute("buses",bus );
//				 RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Customer/BusShowing.jsp");
//		            dispatcher.forward(request, response);
//				 System.out.println(bus);
//			       
//			} 
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String source = request.getParameter("source");
	        String destination = request.getParameter("destination");
	        String travelDateStr = request.getParameter("travelDate");
	        System.out.println(source + " " + destination + " " + travelDateStr);

	        try {
	            LocalDate travelDate = LocalDate.parse(travelDateStr);
	            List<Bus> busList = new BusesDao().busList().stream()
	                    .filter(x -> x.getRoute().getSource().equals(source) 
	                            && x.getRoute().getDestination().equals(destination) 
	                            && x.getDateOfBus().equals(travelDate))
	                    .collect(Collectors.toList());

	            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm a");

	            for (Bus bus : busList) {
	                LocalDateTime departureDateTime = bus.getDepartureTime();
	                LocalDateTime arrivalDateTime = bus.getArrivalTime(); 

	                String formattedDepartureDate = departureDateTime.format(dateFormatter);
	                String formattedDepartureTime = departureDateTime.format(timeFormatter);
	                String formattedArrivalDate = arrivalDateTime.format(dateFormatter);
	                String formattedArrivalTime = arrivalDateTime.format(timeFormatter);
	                bus.setFormattedDepartureDate(formattedDepartureDate);
	                bus.setFormattedDepartureTime(formattedDepartureTime);
	                bus.setFormattedArrivalDate(formattedArrivalDate);
	                bus.setFormattedArrivalTime(formattedArrivalTime);
	            }

	            request.setAttribute("buses", busList);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Customer/BusDetails.jsp");
	            dispatcher.forward(request, response);
	            System.out.println(busList);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
