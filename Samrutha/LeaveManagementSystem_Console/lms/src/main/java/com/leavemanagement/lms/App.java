package com.leavemanagement.lms;

import com.leavemanagement.lms.exception.InvalidInputException;
import com.leavemanagement.lms.style.Border;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Border titleBorder = new Border();
    	String title = "LEAVE MANAGEMENT SYSTEM";
    	titleBorder.applyTitleBorder(title);
        //Calling the main menu 
    	try {
			Menu.displayMainMenu();
		} catch (InvalidInputException e) { 
			System.out.println(e.getMessage());
		}
    }
}
