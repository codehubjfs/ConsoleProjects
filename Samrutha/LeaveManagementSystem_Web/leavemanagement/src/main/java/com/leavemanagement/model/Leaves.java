package com.leavemanagement.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Leaves {
	
	private int leaveId;
	private Employee emp;
	private LeaveType leaveType;
	private LocalDate startDate;
	private LocalDate endDate;
	private String reason;
	private String assignWork;
	private ApplicationStatus status;
	private String rejectionreason;

}
