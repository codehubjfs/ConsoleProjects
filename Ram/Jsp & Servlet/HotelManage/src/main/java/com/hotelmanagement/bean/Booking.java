package com.hotelmanagement.bean;

import java.io.Serializable;
import java.sql.Date;

public class Booking implements Serializable{
	 private int id;
	    private String customerName;
	    private String gender;
	    private String room;
	    private Date checkIn;
	    private Date checkOut;
	    private String bookingStatus;
	    private String phoneNo;
	    private int rent;
	    private int roomType;
	    private String roomName;
	    

	    public String getRoomName() {
			return roomName;
		}

		public void setRoomName(String roomName) {
			this.roomName = roomName;
		}

		public int getRoomType() {
			return roomType;
		}

		public void setRoomType(int roomType) {
			this.roomType = roomType;
		}

		public Booking() {
	        // Default constructor
	    }

	    // Getters and Setters

	    public int getRent() {
			return rent;
		}

		public void setRent(int rent) {
			this.rent = rent;
		}

		public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }

	    public String getGender() {
	        return gender;
	    }

	    public void setGender(String gender) {
	        this.gender = gender;
	    }

	    public String getRoom() {
	        return room;
	    }

	    public void setRoom(String room) {
	        this.room = room;
	    }

	    public Date getCheckIn() {
	        return checkIn;
	    }

	    public void setCheckIn(Date checkIn) {
	        this.checkIn = checkIn;
	    }

	    public Date getCheckOut() {
	        return checkOut;
	    }

	    public void setCheckOut(Date checkOut) {
	        this.checkOut = checkOut;
	    }

	    public String getBookingStatus() {
	        return bookingStatus;
	    }

	    public void setBookingStatus(String bookingStatus) {
	        this.bookingStatus = bookingStatus;
	    }

	    public String getPhoneNo() {
	        return phoneNo;
	    }

	    public void setPhoneNo(String phoneNo) {
	        this.phoneNo = phoneNo;
	    }

	    // toString method (optional)

	    @Override
	    public String toString() {
	        return "Booking{" +
	                "id=" + id +
	                ", customerName='" + customerName + '\'' +
	                ", gender='" + gender + '\'' +
	                ", room='" + room + '\'' +
	                ", checkIn=" + checkIn +
	                ", checkOut=" + checkOut +
	                ", bookingStatus='" + bookingStatus + '\'' +
	                ", phoneNo='" + phoneNo + '\'' +
	                '}';
	    }
	    
	    
		
}
