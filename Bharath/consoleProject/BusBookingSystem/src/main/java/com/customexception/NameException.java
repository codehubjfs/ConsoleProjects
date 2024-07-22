package com.customexception;

public class NameException  extends Exception{
	private static final long serialVersionUID = 1L;

	NameException(String message){
		super(message);
	}
}

