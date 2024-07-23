package com.lms.bean;

public class Department {
	private int deptId;
	private String deptName;
	private String Location;
	
	//Contructor
	public Department() {
		super();
	}

	//Getters and Setters
	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", Location=" + Location + "]";
	}
}
