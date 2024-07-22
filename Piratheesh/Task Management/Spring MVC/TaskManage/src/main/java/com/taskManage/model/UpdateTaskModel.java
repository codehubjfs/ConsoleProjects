package com.taskManage.model;

import org.springframework.stereotype.Component;

@Component
public class UpdateTaskModel {
	
	private int task_id;
	private int task_status;
	private int Emp_id;
	
	
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public int getTask_status() {
		return task_status;
	}
	public void setTask_status(int task_status) {
		this.task_status = task_status;
	}
	public int getEmp_id() {
		return Emp_id;
	}
	public void setEmp_id(int emp_id) {
		Emp_id = emp_id;
	}

}
