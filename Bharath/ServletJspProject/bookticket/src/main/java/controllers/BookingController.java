	package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.stream.Collectors;

import bean.BookingBean;
import bean.Bus;
import bean.Customer;
import bean.Payment;
import bean.RoutesBean;
import dao.BookingDao;
import dao.BusesDao;
import dao.CustomerDao;

/**
 * Servlet implementation class BookingController
 */
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
	private BookingDao bookingDao;
    public BookingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		bookingDao = new BookingDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String customerId=request.getParameter("customerid");
			String busid=request.getParameter("busid");
			String routesid=request.getParameter("routeid");
		    String departure = request.getParameter("boardingPoint");
	        String arrival = request.getParameter("droppingPoint");
	        String seat=request.getParameter("selectedSeats");
	        String seatArray[]=(seat).split(",");
	        int seats[] = new int[seatArray.length];
	        for(int i=0;i<seatArray.length;i++) {
	        	seats[i]=Integer.parseInt(seatArray[i]);
	        }
	        System.out.println(Arrays.toString(seats));
	        int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
	        BookingBean book=new BookingBean();
	        int customersId=Integer.parseInt(customerId);
	        int busId=Integer.parseInt(busid);
	        Bus bus=new Bus();
	        bus.setBusid(busId);
	        RoutesBean routes=new RoutesBean();
	        int routeId=Integer.parseInt(routesid);
	        routes.setIndex(routeId);
	        
	        book.setBus(bus);
	        book.setRoute(routes);
	        book.setDeparture(departure);
	        book.setArrival(arrival);
	        book.setSelectedSeats(seats);
	        book.setTotalPrice(totalPrice);
	        Payment payment=new Payment();
	        payment.setBook(book);
	        HttpSession session = request.getSession();
	        request.getSession().setAttribute("payment", payment);
	        // for showing bus details in passenger.jsp
	        Bus busObj=new BusesDao().busList().stream().filter(b->b.getBusid() == busId).findFirst().orElse(null);
	        book.setBus(busObj);
	       
	        Customer customerObj=new CustomerDao().viewCustomer().stream().filter(customer->customer.getId()==customersId).findFirst().orElse(null);
	        book.setCustomer(customerObj);
	        request.getSession().setAttribute("Bookings", book);
	        request.setAttribute("book", book);
	        System.out.println(customerId+" "+busid+" "+routesid+" "+departure+" "+arrival+" "+seat+" "+totalPrice);
	        request.getRequestDispatcher("view/Customer/Payment.jsp").forward(request, response);
	        
		}
	    catch (Exception e) {
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
