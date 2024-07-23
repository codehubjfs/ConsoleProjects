package com.exception;

public class EmailException extends Exception{
	public EmailException(String s)
	{
		super(s);
	}
	public String getMessage()
	{
		return "Invalid  Email. Please enter correct email-format(abc@gmail.com OR abc@ac.in)";
	}

}
