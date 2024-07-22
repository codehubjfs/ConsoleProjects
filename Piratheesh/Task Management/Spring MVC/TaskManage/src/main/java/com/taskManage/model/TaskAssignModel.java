package com.taskManage.model;

import org.springframework.stereotype.Component;

@Component
public class TaskAssignModel {

	private int task_id;
	private String task_name;
	private String task_desp;
	private String task_priortiy;
	private String name;
	private int emp_id;
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
	public String getTask_priortiy() {
		return task_priortiy;
	}
	public void setTask_priortiy(String task_priortiy) {
		this.task_priortiy = task_priortiy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

	@Override
	public String toString() {
		return "TaskAssignModel [task_id=" + task_id + ", task_name=" + task_name + ", task_desp=" + task_desp
				+ ", task_priortiy=" + task_priortiy + ", name=" + name + ", emp_id=" + emp_id + ", status=" + status
				+ "]";
	}
	
}
