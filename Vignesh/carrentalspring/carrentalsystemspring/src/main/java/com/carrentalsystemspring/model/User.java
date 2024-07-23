package com.carrentalsystemspring.model;

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
public class User {
	private int user_id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private String phone_number;
    private String password;
    private String account_status;
    private String username;
    
}
