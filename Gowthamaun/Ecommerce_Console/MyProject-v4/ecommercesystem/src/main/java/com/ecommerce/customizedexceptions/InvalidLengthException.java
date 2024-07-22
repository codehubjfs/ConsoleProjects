package com.ecommerce.customizedexceptions;

public class InvalidLengthException extends Exception{
	public InvalidLengthException(String message) {
		super(message);
	}
}
