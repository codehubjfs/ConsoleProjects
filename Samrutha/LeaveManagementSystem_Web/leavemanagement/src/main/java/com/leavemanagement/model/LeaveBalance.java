package com.leavemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LeaveBalance {
	
	private int leaveTypeId;
	private Employee emp;
	private int sickLeave;
	private int casualLeave;
	private int vacationLeave;
	private int balanceLeave;
	private int totalLeave;
	
}
