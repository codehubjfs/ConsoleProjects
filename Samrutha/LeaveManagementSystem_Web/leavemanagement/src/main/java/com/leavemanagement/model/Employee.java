package com.leavemanagement.model;

import java.time.LocalDate;

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

public class Employee {
	
	private int empID;
	private String firstName;
	private String lastName;
	private String email;
	private Department department;
	private int managerId;
	private LocalDate joinDate;
	private int salary;
	private Gender gender;
	private Role role;
	private AccountStatus status;
	private String username;
	private String password;
	
}
