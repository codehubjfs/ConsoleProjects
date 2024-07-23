package com.taskmanagement.beans;

import java.time.LocalDate;

public class PersonalTaskAddBeans {
	
	private int task_id;
	private String task_name;
	private String desp;
	private LocalDate start_date;
	private LocalDate end_date;
	private String priority;
	private String email;
	private String status;
	
	
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public String getDesp() {
		return desp;
	}
	public void setDesp(String desp) {
		this.desp = desp;
	}
	public LocalDate getStart_date() {
		return start_date;
	}
	public LocalDate getEnd_date() {
		return end_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
