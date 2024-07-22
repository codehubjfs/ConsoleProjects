package com.lms.bean;

public class BalanceLeaveBean {
	private int leaveTypeId;
	private Employee emp;
	private int sickLeave;
	private int casualLeave;
	private int vacationLeave;
	private int balanceLeave;
	private int totlaLeave;
	
	
	public BalanceLeaveBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getLeaveTypeId() {
		return leaveTypeId;
	}


	public void setLeaveTypeId(int leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}


	public Employee getEmp() {
		return emp;
	}


	public void setEmp(Employee emp) {
		this.emp = emp;
	}


	public int getSickLeave() {
		return sickLeave;
	}


	public void setSickLeave(int sickLeave) {
		this.sickLeave = sickLeave;
	}


	public int getCasualLeave() {
		return casualLeave;
	}


	public void setCasualLeave(int casualLeave) {
		this.casualLeave = casualLeave;
	}


	public int getVacationLeave() {
		return vacationLeave;
	}


	public void setVacationLeave(int vacationLeave) {
		this.vacationLeave = vacationLeave;
	}


	public int getBalanceLeave() {
		return balanceLeave;
	}


	public void setBalanceLeave(int balanceLeave) {
		this.balanceLeave = balanceLeave;
	}


	public int getTotlaLeave() {
		return totlaLeave;
	}


	public void setTotlaLeave(int totlaLeave) {
		this.totlaLeave = totlaLeave;
	}


	@Override
	public String toString() {
		return "BalanceLeaveBean [leaveTypeId=" + leaveTypeId + ", emp=" + emp + ", sickLeave=" + sickLeave
				+ ", casualLeave=" + casualLeave + ", vacationLeave=" + vacationLeave + ", balanceLeave=" + balanceLeave
				+ ", totlaLeave=" + totlaLeave + "]";
	}
}
