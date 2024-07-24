package com.hallbookingmanagement.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {
	  private int bookingId;
	  private Customer customer;
	  private Hall hall;
	  private LocalDateTime requestedTime;
	  private LocalDate startDate;
	  private LocalDate endDate;
	  private String bookStatus;
	  
	  public Booking() {
		  
	  }
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
		public Hall getHall() {
			return hall;
		}
		public void setHall(Hall hall) {
			this.hall = hall;
		}
		public LocalDateTime getRequestedTime() {
			return requestedTime;
		}
		public void setRequestedTime(LocalDateTime requestedTime) {
			this.requestedTime = requestedTime;
		}
		public LocalDate getStartDate() {
			return startDate;
		}
		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}
		public LocalDate getEndDate() {
			return endDate;
		}
		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
		}
		public String getBookStatus() {
			return bookStatus;
		}
		public void setBookStatus(String bookStatus) {
			this.bookStatus = bookStatus;
		}
		@Override
		public String toString() {
			return "Booking [bookingId=" + bookingId + ", customer=" + customer + ", hall=" + hall + ", requestedTime="
					+ requestedTime + ", startDate=" + startDate + ", endDate=" + endDate + ", bookStatus=" + bookStatus
					+ "]";
		}
}