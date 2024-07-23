package com.springmvc.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Student {
	
	private int stud_id;
	private String mailid;
	private String password;
	private String department;
	private int roomno;
	private String blockno;
	private String phonenumber;
	private String role;
	private String name;
	
	
	

}
