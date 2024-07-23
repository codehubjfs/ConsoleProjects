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

public class Payment {
	private int paymentId;
    private int bookingId;
    private double paymentAmt;
    private Date paymentDate;
    private String paymentMethod;
    private String paymentStatus;
    
}
