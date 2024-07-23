package com.hotelmanagement.bean;

import java.io.Serializable;
import java.sql.Date;

public class Keeper implements Serializable{
	
	
	    private int id;
	    private String keeperName;
	    private String email;
	    private String phoneNo;
	    private Date lastCleanDate;
	    private Date nextCleanDate;
	    private String password;
	    private String status;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getKeeperName() {
			return keeperName;
		}
		public void setKeeperName(String keeperName) {
			this.keeperName = keeperName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhoneNo() {
			return phoneNo;
		}
		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}
		  public Date getLastCleanDate() {
		        return lastCleanDate;
		    }

		    public void setLastCleanDate(Date lastCleanDate) {
		        this.lastCleanDate = lastCleanDate;
		    }

		    public Date getNextCleanDate() {
		        return nextCleanDate;
		    }

		    public void setNextCleanDate(Date nextCleanDate) {
		        this.nextCleanDate = nextCleanDate;
		    }
		public String getPassword() {
			return password;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	    
}