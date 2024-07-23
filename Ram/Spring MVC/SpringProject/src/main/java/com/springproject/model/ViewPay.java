package com.springproject.model;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor

public class ViewPay {
	private int payment_id;
    private int booking_id;
    private double payment_amt;
    private Date payment_date;
    private String payment_method;
    private String payment_status;

}
