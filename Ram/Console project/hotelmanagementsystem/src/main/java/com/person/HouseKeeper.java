package com.person;

import java.time.LocalDate;

public class HouseKeeper {
	private String name;
	private int keeper_id;
	private String email;
	private long phone_no;
	private String password;	
	private LocalDate last_clean;
	private LocalDate next_clean;
//	private int room_no;
	public HouseKeeper(String name, int keeper_id, String email, long phone_no, String password, LocalDate last_clean,
			LocalDate next_clean) {
		super();
		this.name = name;
		this.keeper_id = keeper_id;
		this.email = email;
		this.phone_no = phone_no;
		this.password = password;
		this.last_clean = last_clean;
		this.next_clean = next_clean;
	}
	public HouseKeeper(String name2, String email2, long phoneNo, LocalDate lastCleanDate, LocalDate nextCleanDate) {
		this.name=name2;
		this.email=email2;
		this.phone_no=phoneNo;
		this.last_clean=lastCleanDate;
		this.next_clean=nextCleanDate;
	}
	public HouseKeeper(String name2, String email2, long phone, String pass, LocalDate lastdate, LocalDate nextdate) {
		// TODO Auto-generated constructor stub
		this.name=name2;
		this.email=email2;
		this.phone_no=phone;
		this.password=pass;
		this.last_clean=lastdate;
		this.next_clean=nextdate;
	}
	public HouseKeeper() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKeeper_id() {
		return keeper_id;
	}
	public void setKeeper_id(int keeper_id) {
		this.keeper_id = keeper_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getLast_clean() {
		return last_clean;
	}
	public void setLast_clean(LocalDate last_clean) {
		this.last_clean = last_clean;
	}
	public LocalDate getNext_clean() {
		return next_clean;
	}
	public void setNext_clean(LocalDate next_clean) {
		this.next_clean = next_clean;
	}
	@Override
	
	    public String toString() {
	        return String.format("| %-15s | %-14s | %-11d | %-12s | %-12s |",
	                email, name, phone_no, last_clean, next_clean);
	    }
	
	
}
