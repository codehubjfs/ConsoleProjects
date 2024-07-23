package com.springproject.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Component
public class LoginRegister {
		private int id;
	 	private String first_name;
	    private String last_name;
	    private int age;
	    private String gender;
	    private String phone;
	    private String address;
	    private String state;
	    private String email;
	    private String password;

}
