package com.springproject.model;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class Booking {
	private int id;
    private String customer_name;
//    private String customerName;
    private String gender;
    private int room;
    private Date check_in;
    private Date check_out;
    private String booking_status;
    private String phoneNo;
    private int rent;
    private int roomType;
    private String roomName;

    private String phone_no;
}
