package com.carrentalsystemspring.model;

import java.security.Timestamp;
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
public class Payment {
	private Long id;
    private String username;
    private String carname;
    private String cardholder_name;
    private String cardNumber;
    private String cardType;
    private Date expDate;
    private String cvv;
    private Date createdAt;
}
