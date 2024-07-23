package com.bus.model;
public class Booking {
	private int bookingid;
	private CustomersNew customer;
	private Bus bus;
	private Routes route;
	private String boardingPoint;
	private String droppingPoint;
	private int selectedSeats;
	private double totalPrice;
	private String bookingStatus;

	public Booking() {
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Routes getRoute() {
		return route;
	}

	public void setRoute(Routes route) {
		this.route = route;
	}

	public Booking(CustomersNew customer, Bus bus, Routes route, String boardingPoint, String droppingPoint,
			int selectedSeats, double totalPrice, String bookingStatus) {
		this.customer = customer;
		this.bus = bus;
		this.route = route;
		this.boardingPoint = boardingPoint;
		this.droppingPoint = droppingPoint;
		this.selectedSeats = selectedSeats;
		this.totalPrice = totalPrice;
		this.bookingStatus = bookingStatus;
	}

	public CustomersNew getCustomer() {
		return customer;
	}

	public void setCustomer(CustomersNew customer) {
		this.customer = customer;
	}

	public String getBoardingPoint() {
		return boardingPoint;
	}

	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}

	public String getDroppingPoint() {
		return droppingPoint;
	}

	public void setDroppingPoint(String droppingPoint) {
		this.droppingPoint = droppingPoint;
	}

	public int getSelectedSeats() {
		return selectedSeats;
	}

	public void setSelectedSeats(int selectedSeats) {
		this.selectedSeats = selectedSeats;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	@Override
	public String toString() {
		return "Booking [bookingid=" + bookingid + ",\n customer=" + customer + ",\n bus=" + bus + ",\n route=" + route
				+ ", boardingPoint=" + boardingPoint + ", droppingPoint=" + droppingPoint + ", selectedSeats="
				+ selectedSeats + ", totalPrice=" + totalPrice + ", bookingStatus=" + bookingStatus + "]";
	}
	
}
