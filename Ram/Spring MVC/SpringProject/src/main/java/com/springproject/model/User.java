package com.springproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class User {
	
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
