package com.leavemanagement.lms.exception;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ExceptionValidator {
	
	//Password pattern check
	public boolean isValidPassword(String password) {
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
	    return password.matches(regex);
	 }
	
	//Validating the input
	public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
	
	//Validate the date
	public LocalDate validateDate(String dateString) throws InvalidDateException {
		LocalDate date;
		try {
            date = LocalDate.parse(dateString);
            int year = date.getYear();
            int month = date.getMonthValue();
            int day = date.getDayOfMonth();
            if ((year < LocalDate.now().getYear() || year > LocalDate.now().getYear() + 1)
                    || (year == LocalDate.now().getYear() && month < LocalDate.now().getMonthValue())
                    || (year == LocalDate.now().getYear() && month == LocalDate.now().getMonthValue() && day < LocalDate.now().getDayOfMonth())
                    || month < 1 || month > 12
                    || day < 1 || day > date.lengthOfMonth()) {
                throw new InvalidDateException("Please enter the valid date...\nInvalid Year or Month or Date\nFormat: "
                        + "\nYear: " + LocalDate.now().getYear() + " to " + (LocalDate.now().getYear() + 1)
                        + "\nMonth: 01 to 12"
                        + "\nDate: 1 to 30/31 Except February");
            }
        } catch (DateTimeParseException e) {
            throw new InvalidDateException("Please enter valid date (YYYY-MM-DD)");
        }
        return date;
    }
	
	
	//Valid hire date
	public LocalDate validateHireDate(String dateString) throws InvalidDateException {
		LocalDate date;
		try {
            date = LocalDate.parse(dateString);
            int year = date.getYear();
            int month = date.getMonthValue();
            int day = date.getDayOfMonth();
            if ((year < LocalDate.now().getYear() || year > LocalDate.now().getYear() + 1)
                    || month < 1 || month > 12
                    || day < 1 || day > date.lengthOfMonth()) {
                throw new InvalidDateException("Please enter the valid date...\nInvalid Year or Month or Date\nFormat: "
                        + "\nYear: " + LocalDate.now().getYear() + " to " + (LocalDate.now().getYear() + 1)
                        + "\nMonth: 01 to 12"
                        + "\nDate: 1 to 30/31 Except February");
            }
        } catch (DateTimeParseException e) {
            throw new InvalidDateException("Please enter valid date (YYYY-MM-DD)");
        }
        return date;
    }
}
