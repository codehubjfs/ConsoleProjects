package com.taskManage.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class PersonalTaskModel {
	
	private int task_id;
	private String task_name;
	private String task_desp;
	private LocalDate start_date;
	private LocalDate end_date;
	private String task_priority;
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
	public String getTask_desp() {
		return task_desp;
	}
	public void setTask_desp(String task_desp) {
		this.task_desp = task_desp;
	}
	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	public LocalDate getEnd_date() {
		return end_date;
	}
	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}
	public String getTask_priority() {
		return task_priority;
	}
	public void setTask_priority(String task_priority) {
		this.task_priority = task_priority;
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
