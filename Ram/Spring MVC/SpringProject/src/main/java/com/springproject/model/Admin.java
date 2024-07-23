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
public class Admin {

	private int adminId;
    private String username;
    private String password;
    private String email;
    private String phone_no;
    private String address;
    private String name;
}
