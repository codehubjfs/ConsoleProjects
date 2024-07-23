package com.springproject.model;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ViewBook {
	   // Bookings table fields
    private int id; // Assuming this is the booking ID
    private String customer_name;
    private String gender;
    private int room;
    private Date check_in;
    private Date check_out;
    private String booking_status;
    private String phoneNo;
    private int roomType;
    private String roomName;
    // Users table fields
    private int userId; // Assuming this is the user ID
    private String first_name;
    private String phone;
    private String address;
    private String state;
    private String email;
}
