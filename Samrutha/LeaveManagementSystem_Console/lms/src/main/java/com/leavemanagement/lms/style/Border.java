package com.leavemanagement.lms.style;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.leavemanagement.lms.leave.LeaveApplication;

public class Border {
	
	public void applyTitleBorder(String title) {
		// Assuming the console width is 100 characters
        int consoleWidth = 80;

        // Calculate the padding for the title to center it
        int padding = (consoleWidth - title.length() - 4) / 2; 

        // Create the border lines with double lines
        String topBorder = " ".repeat(padding) + "╔" + "═".repeat(title.length() + 2) + "╗";
        String emptyBorder = " ".repeat(padding) + "║" + " ".repeat(title.length() + 2) + "║";
        String titleLine = " ".repeat(padding) + "║ " + title + " ║";
        String bottomBorder = " ".repeat(padding) + "╚" + "═".repeat(title.length() + 2) + "╝";

        // Print the banner
        System.out.println(topBorder);
        System.out.println(emptyBorder);
        System.out.println(titleLine);
        System.out.println(emptyBorder);
        System.out.println(bottomBorder);
        System.out.println();
	}
	
	public void applyNoteBorder(String title) {
		int consoleWidth = 80; // Adjust this value based on your console width
		int paddingAroundTitle = 10; // Padding inside the box around the title

        // Calculate the width of the box
        int boxWidth = title.length() + paddingAroundTitle * 2 + 2; // padding on each side and 2 border characters
        int outerPadding = (consoleWidth - boxWidth) / 2;

        // Construct the box components
        String topBorder = " ".repeat(outerPadding) + "╔" + "═".repeat(boxWidth - 2) + "╗";
        String emptyBorder = " ".repeat(outerPadding) + "║" + " ".repeat(boxWidth - 2) + "║";
        String titleLine = " ".repeat(outerPadding) + "║" + " ".repeat(paddingAroundTitle) + title + " ".repeat(paddingAroundTitle) + "║";
        String bottomBorder = " ".repeat(outerPadding) + "╚" + "═".repeat(boxWidth - 2) + "╝";

        // Print the box
        System.out.println(topBorder);
        System.out.println(emptyBorder);
        System.out.println(titleLine);
        System.out.println(emptyBorder);
        System.out.println(bottomBorder);
	}
	
	
	//Display the details of the employee
	public void displayEmployeeInfo(ResultSet rs) throws SQLException {
        String[] fields = {
            "EmployeeID = " + rs.getInt("empID"),
            "UserName = " + rs.getString("userName"),
            "FirstName = " + rs.getString("fname"),
            "LastName = " + rs.getString("lname"),
            "Email = " + rs.getString("email"),
            "JobRole = " + rs.getString("role"),
            "Joined Date = " + rs.getDate("joindate").toLocalDate()
        };

        int consoleWidth = 80; // Adjust this value based on your console width
        int maxFieldLength = 0;

        // Find the longest line
        for (String field : fields) {
            if (field.length() > maxFieldLength) {
                maxFieldLength = field.length();
            }
        }

        // Calculate the width of the box
        int boxWidth = maxFieldLength + 4; // 2 spaces on each side of the longest line and 2 border characters
        int outerPadding = (consoleWidth - boxWidth) / 2;

        // Construct the box components
        String topBorder = " ".repeat(outerPadding) + "╔" + "═".repeat(boxWidth - 2) + "╗";
        String bottomBorder = " ".repeat(outerPadding) + "╚" + "═".repeat(boxWidth - 2) + "╝";

        // Print the top border
        System.out.println(topBorder);

        // Print each field line with padding
        for (String field : fields) {
            String paddedField = " ".repeat(outerPadding) + "║ " + field + " ".repeat(boxWidth - field.length() - 3) + "║";
            System.out.println(paddedField);
        }

        // Print the bottom border
        System.out.println(bottomBorder);
    }

	public void displayLeaveInfo(LeaveApplication rs) throws SQLException {
	    String[] fields = {
	        "EmployeeID = " + rs.getEmployee().getEmpId(), 
	        "Leave Type = " + rs.getLeavetype(),
	        "Start Date = " + rs.getStartDate(),
	        "End Date = " + rs.getEndDate(),
	        "Leave Reason = " + rs.getLeaveReason(),
	        "Submit Date = " + rs.getSubmitDate(),
	        "Status = " + rs.getStatus(),
	        "Rejection Reason = "+ rs.getRejectionReason(),
	        "Work Altered = " + rs.getWorkAssigned()
	    };
	
	    int consoleWidth = 80; // Adjust this value based on your console width
	    int maxFieldLength = 0;
	
	    // Find the longest line
	    for (String field : fields) {
	        if (field.length() > maxFieldLength) {
	            maxFieldLength = field.length();
	        }
	    }
	
	    // Calculate the width of the box
	    int boxWidth = maxFieldLength + 4; // 2 spaces on each side of the longest line and 2 border characters
	    int outerPadding = (consoleWidth - boxWidth) / 2;
	
	    // Construct the box components
	    String topBorder = " ".repeat(outerPadding) + "╔" + "═".repeat(boxWidth - 2) + "╗";
	    String bottomBorder = " ".repeat(outerPadding) + "╚" + "═".repeat(boxWidth - 2) + "╝";
	
	    // Print the top border
	    System.out.println(topBorder);
	
	    // Print each field line with padding
	    for (String field : fields) {
	        String paddedField = " ".repeat(outerPadding) + "║ " + field + " ".repeat(boxWidth - field.length() - 3) + "║";
	        System.out.println(paddedField);
	    }
	
	    // Print the bottom border
	    System.out.println(bottomBorder);
	}
	
}
