package com.springmvc.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
	
	private int adminid;
	private String mailid;
	private String password;
	private String name;

}
