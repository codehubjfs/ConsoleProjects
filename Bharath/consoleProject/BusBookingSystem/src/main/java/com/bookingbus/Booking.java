package com.bookingbus;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.databaseconnection.DbConnection;
import com.persondetails.Customer;

public class Booking {
	private int bookingId;
	private Customer customer;
	private int seatNumber;
	private String bookingStatus;
	private LocalDate bookedDate;
	private Bus bus;

	public Booking() {
		super();
	}

	public Booking(int bookingId, Customer customer, int seatNumber, String bookingStatus, LocalDate bookedDate,
			Bus bus) {
		super();
		this.bookingId = bookingId;
		this.customer = customer;
		this.seatNumber = seatNumber;
		this.bookingStatus = bookingStatus;
		this.bookedDate = bookedDate;
		this.bus = bus;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Booking(int bookingId, Customer customer, int seatNumber, String bookingStatus, LocalDate bookedDate) {
		super();
		this.bookingId = bookingId;
		this.customer = customer;
		this.seatNumber = seatNumber;
		this.bookingStatus = bookingStatus;
		this.bookedDate = bookedDate;

	}

	public Booking(int bookingId, int seatNumber, String bookingStatus, LocalDate bookedDate) {
		super();
		this.bookingId = bookingId;
		this.seatNumber = seatNumber;
		this.bookingStatus = bookingStatus;
		this.bookedDate = bookedDate;
	}
	//book=new Booking(resultSet.getInt("bookingId"),resultSet.getInt("CustomerId"),resultSet.getInt("seatnumber"),resultSet.getString("bookingstatus"),resultSet.getDate("bookeddate"),resultSet.getString("busname"),resultSet.getString("busType"),resultSet.getInt("busFare"),resultSet.getDate("dayofroute"));
	//book=new Booking(resultSet.getInt("bookingId"),resultSet.getInt("CustomerId"),resultSet.getInt("seatnumber"),resultSet.getString("bookingstatus"),resultSet.getDate("bookeddate"),resultSet.getString("busname"),resultSet.getInt("busFare"),resultSet.getDate("dayofroute"));

//	book=new Booking(resultSet.getInt("bookingId"),resultSet.getInt("CustomerId"),resultSet.getInt("seatnumber"),resultSet.getString("bookingstatus"),resultSet.getDate("bookeddate"),resultSet.getString("busname"),resultSet.getString("busType"),resultSet.getInt("busFare"),resultSet.getDate("dayofroute"));
	

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public LocalDate getDay() {
		return bookedDate;
	}

	public void setDay(LocalDate date) {
		this.bookedDate = date;
	}

	public LocalDate getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(LocalDate bookedDate) {
		this.bookedDate = bookedDate;
	}

	public ArrayList<Booking> bookList() {
		ArrayList<Booking> list = new ArrayList<>();
		try {
			String sqlBook = "select * from book bk Left join bus bs on bk.busid=bs.bus_id";
			PreparedStatement statement = DbConnection.getDBConnection().prepareStatement(sqlBook);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Booking book = new Booking();
				book.setBookingId(rs.getInt("BOOKINGID"));
				book.setCustomer(customer);
				book.setSeatNumber(rs.getInt("SEATNUMBER"));
				book.setBookingStatus(rs.getString("BOOKINGSTATUS"));
				book.setDay(rs.getDate("bookedDate").toLocalDate());
				Customer customer = new Customer();
				customer.setCustid(rs.getInt("CUSTOMER_ID"));
				Bus bus = new Bus();
				bus.setBusid(rs.getInt("BUSID"));
				bus.setDateOfBus(rs.getDate("DAYOFROUTE").toLocalDate());
				book.setBus(bus);
				//bus.setDateOfBus();
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", customer=" + customer + ", seatNumber=" + seatNumber
				+ ", BookingStatus=" + bookingStatus + ", bookedDate=" + bookedDate + ", bus=" + bus + "]";
	}
	
}
