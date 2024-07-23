package com.exception;

public class DefaultException extends Exception {
	public DefaultException(String s)
	{
		super(s);
	}
	public String getMessage()
	{
		return "Invalid option";
				
	}
}
