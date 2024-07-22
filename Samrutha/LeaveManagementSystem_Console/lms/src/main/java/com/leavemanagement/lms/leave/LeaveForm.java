package com.leavemanagement.lms.leave;

import java.time.LocalDate;
import java.util.Scanner;

import com.leavemanagement.lms.employee.Employee;

public class LeaveForm {
	
	static Scanner sc = new Scanner(System.in);
	public static LeaveApplication readLeaveData() {
		System.out.print("Enter employee id: ");
		int empId = sc.nextInt();
		LeaveType leaveType = LeaveType.VACATION_LEAVE;
		System.out.println("Enter leave type: ");
		while(true) {
			System.out.println("1. SICK_LEAVE\t2. CASUAL_LEAVE\t3. VACATION_LEAVE\t4. MATERNITY_LEAVE\t5. MARRIAGE_LEAVE\t6. Exit");
			System.out.println("Enter your choice[1 to 6]: ");
			int choice = sc.nextInt();
			if(choice==6) {
				break;
			}
			switch(choice) {
			case 1: leaveType = LeaveType.SICK_LEAVE; break;
			case 2: leaveType = LeaveType.CASUAL_LEAVE; break;
			case 3: leaveType = LeaveType.VACATION_LEAVE; break;
			case 4: leaveType = LeaveType.MATERNITY_LEAVE; break;
			case 5: leaveType = LeaveType.MARRIAGE_LEAVE; break;
			}
			break;
		}
		System.out.print("Enter start date as 'YYYY MM DD': ");
		LocalDate startDate = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
		System.out.print("Enter end date as 'YYYY MM DD': ");
		LocalDate endDate = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
		sc.nextLine();
		System.out.println("Enter leave reason: ");
		String leaveReason = sc.nextLine();
		System.out.println("Enter the username to whom do you like to assign the task: ");
		int alterEmp = sc.nextInt();
		
		//changes made now
		Employee emp = new Employee();
		emp.setEmpId(empId);
		sc.close();
		LeaveApplication apl = new LeaveApplication(emp, leaveType , startDate, endDate, leaveReason, LocalDate.now(),Status.WAITING_IN_QUEUE,null,alterEmp);
		return apl;
	}
}
