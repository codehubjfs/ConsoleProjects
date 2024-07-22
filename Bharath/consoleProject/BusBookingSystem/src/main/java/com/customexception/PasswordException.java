package com.customexception;

public class PasswordException extends Exception{

	private static final long serialVersionUID = 1L;

	PasswordException(String message){
		super(message);
	}
}


