package com.ecommerce.customizedexceptions;

public class InvalidUserNameException extends Exception{
	public InvalidUserNameException(String message) {
		super(message);
	}
}
