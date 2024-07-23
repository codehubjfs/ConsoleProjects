package com.carrentalsystemspring.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
	private int booking_id;
    private Date start_date;
    private Date end_date;
    private String booking_status;
    private String car_name;
    private String user_name;
    private double rental_rate;
	
	
	
	
	
	
	
	
	
	
}
