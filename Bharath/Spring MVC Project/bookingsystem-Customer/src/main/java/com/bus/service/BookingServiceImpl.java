package com.bus.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bus.mapper.BookingMapper;
import com.bus.mapper.BusMapper;
import com.bus.mapper.PaymentMapper;
import com.bus.mapper.RoutesMapper;
import com.bus.model.Booking;
import com.bus.model.Bus;
import com.bus.model.CustomersNew;
import com.bus.model.Payment;
import com.bus.model.Routes;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingMapper bookingMapper;
   
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private BusMapper busMapper;
    
    @Autowired
    private RoutesMapper routesMapper;
    
    @Autowired
    private PaymentMapper paymentMapper;

    //@Transactional
	    public List<Booking> bookSeats(int customer_Id, int busId, int routeId, String boardingPoint, String droppingPoint, List<Integer> seatNumber, double totalPrice, String bookingStatus) {
	    	List<Booking> bookedSeatsId=new ArrayList<>();
	        for (int selectedSeats :seatNumber ) {
	        	//customer id
	            CustomersNew customer = new CustomersNew();
	            customer.setCustomer_id(customer_Id);
	            //Bus id
	            Bus bus = new Bus();
	            bus.setBusid(busId);
	            //Route id
	            Routes route = new Routes();
	            route.setIndex(routeId);
	            Bus busesDetails = getAllBus().stream().filter(x->x.getBusid()==busId).findFirst().orElse(null);
//	            System.out.println(busesDetails.getBusName());
//	            System.out.println(busesDetails.getBusType());
	            Booking booking = new Booking(customer, bus, route, boardingPoint, droppingPoint, selectedSeats, totalPrice, bookingStatus);
	            booking.setBus(busesDetails);
	           System.out.println("Booking the bus"+booking.getBus().getBusName());
	            System.out.println(busesDetails);
	            booking.setCustomer(customer);
	            booking.setBus(bus);
	            booking.setRoute(route);
	            bookingMapper.bookSeats(booking);
	            System.out.println("BookingServiceImpl");
	            System.out.println("Booking Id : "+booking.getBookingid());
	            bookedSeatsId.add(booking);
	            
	        }
	        System.out.println(bookedSeatsId);
	        
			return bookedSeatsId;
	    }

	@Override
	public List<Booking> bookingList() {
		        return bookingMapper.bookingList();
	}

	@Override
	public List<Booking> getAllBooking() {
		List <Booking> bookingList =bookingList();
		
        List <CustomersNew> customerList = customerService.viewCustomer();
        
        List<Booking> allBooking = new ArrayList<>();
        for(Booking book:bookingList) {
      	  CustomersNew customerObj = customerList.stream().filter(x->x.getCustomer_id()==book.getCustomer().getCustomer_id()).findAny().orElse(null);
      	  Bus bus = getAllBus().stream().filter(x->x.getBusid()==book.getBus().getBusid()).findFirst().orElse(null);
      	  book.setBus(bus);
      	  book.setCustomer(customerObj);
      	  allBooking.add(book);
        }
        System.out.println("based on busid");
        System.out.println(allBooking);
        System.out.println("---");
		return allBooking;
	}
	
	
	@Override
	public List<Bus> getAllBus() {
		List<Bus> busesList=busMapper.busList();
		List<Routes> routesList= routesMapper.getAllRoutes();
		List<Bus> busRouteList=new ArrayList();
		for(Bus bus:busesList) {
			Routes route = routesList.stream().filter(x->x.getIndex()==bus.getRoute().getIndex()).findFirst().orElse(null);
			bus.setRoute(route);
			busRouteList.add(bus);
		}
		System.out.println("-----------------");
		System.out.println(busRouteList);
		System.out.println("-----------------");
		return busRouteList;
	}

	@Override
	public List<Payment> getAllpayment() {
		List<Payment> paymentLists=paymentMapper.getAllpayment();
		List<Booking> bookingList=getAllBooking();
		List<Payment> paymentBookingList=new ArrayList();
		for(Payment payment:paymentLists) {
			Booking booking=bookingList.stream().filter(x->x.getBookingid()==payment.getBook().getBookingid()).findFirst().orElse(null);
			payment.setBook(booking);
			paymentBookingList.add(payment);
			
			
			System.out.println("-------------------------");
			
			System.out.println(payment);
		}
		return paymentBookingList;
		
	}

	  @Override
	    public void cancelBooking(int bookingId) {
	        bookingMapper.cancelBooking(bookingId);
	    }

	@Override
	public Booking getBookingById(int bookingId) {
		 return bookingMapper.getBookingById(bookingId);
		
	}

	
}


