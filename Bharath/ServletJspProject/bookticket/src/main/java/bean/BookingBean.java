package bean;

import java.util.Arrays;

public class BookingBean {
	private int bookId;
	private String departure;
	private String arrival;
	private int[] selectedSeats;
	private int totalPrice;
	private Bus bus;
	private RoutesBean route;
	private Customer customer;
	
	
	public BookingBean() {
		super();
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	
	public int[] getSelectedSeats() {
		return selectedSeats;
	}
	public void setSelectedSeats(int[] selectedSeats) {
		this.selectedSeats = selectedSeats;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public RoutesBean getRoute() {
		return route;
	}
	public void setRoute(RoutesBean route) {
		this.route = route;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "BookingBean [bookId=" + bookId + ", departure=" + departure + ", arrival=" + arrival
				+ ", selectedSeats=" + Arrays.toString(selectedSeats) + ", totalPrice=" + totalPrice + ", bus=" + bus
				+ ", route=" + route + ", customer=" + customer + "]";
	}
}
