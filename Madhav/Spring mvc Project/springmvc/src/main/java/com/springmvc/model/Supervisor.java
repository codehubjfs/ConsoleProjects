package com.springmvc.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Supervisor {
	
	private int supervisorid;
	private String mailid;
	private String password;
	private String name;
	private String role;
	private String department;

}
