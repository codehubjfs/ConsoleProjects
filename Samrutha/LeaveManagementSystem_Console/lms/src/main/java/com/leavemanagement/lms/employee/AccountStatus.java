package com.leavemanagement.lms.employee;

public enum AccountStatus {

	ACTIVE, INACTIVE;
	
	
	//Conversion of string value to enumerator
	public static AccountStatus mapToStatus(String value) {
		if(AccountStatus.ACTIVE.name().equals(value)) {
			return AccountStatus.ACTIVE;
		}
		else {
			return AccountStatus.INACTIVE;
      }
	}
	
}
