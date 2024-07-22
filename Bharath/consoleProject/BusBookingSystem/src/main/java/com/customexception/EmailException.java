package com.customexception;

public class EmailException extends Exception{
	EmailException(String message){
		super(message);
	}
}