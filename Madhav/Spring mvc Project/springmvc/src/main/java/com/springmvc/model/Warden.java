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
public class Warden {
	
	private String wardenid;
	private String mailid;
	private String password;
	private String name;
	private String role;

}
