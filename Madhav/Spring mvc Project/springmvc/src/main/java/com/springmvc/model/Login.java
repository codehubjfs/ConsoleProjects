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
public class Login {
	
	private String mailid;
	private String password;
	private String role;

}
