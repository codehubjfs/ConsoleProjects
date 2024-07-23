package com.springproject.model;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class Staff {
	
	 private int staff_id;
	    private String name;
	    private String email;
	    private String password;
	    private String phone_no;
}
