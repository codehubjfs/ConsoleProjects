package com.hotelmanagement.bean;

import java.io.Serializable;

public class Room implements Serializable {
	   private int roomId;
	    private int typeId;
	    private String roomName;
	    private String roomStatus;
	    private String roomCondition;
	  
	    public Room() {
	    	
	    }
		public int getRoomId() {
			return roomId;
		}
		public void setRoomId(int roomId) {
			this.roomId = roomId;
		}
		public int getTypeId() {
			return typeId;
		}
		public void setTypeId(int typeId) {
			this.typeId = typeId;
		}
		public String getRoomName() {
			return roomName;
		}
		public void setRoomName(String roomName) {
			this.roomName = roomName;
		}
		public String getRoomStatus() {
			return roomStatus;
		}
		public void setRoomStatus(String roomStatus) {
			this.roomStatus = roomStatus;
		}
		public String getRoomCondition() {
			return roomCondition;
		}
		public void setRoomCondition(String roomCondition) {
			this.roomCondition = roomCondition;
		}
		


}
