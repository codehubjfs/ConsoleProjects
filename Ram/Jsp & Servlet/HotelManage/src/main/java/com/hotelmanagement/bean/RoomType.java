package com.hotelmanagement.bean;

import java.io.Serializable;

public class RoomType implements Serializable{
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int typeId;
    private String roomName;
    private int bedCapacity;
    private String amenity;
    private int noOfRooms;
    private int rent;
	    
	    public RoomType() {
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

		public int getBedCapacity() {
			return bedCapacity;
		}

		public void setBedCapacity(int bedCapacity) {
			this.bedCapacity = bedCapacity;
		}

		public String getAmenity() {
			return amenity;
		}

		public void setAmenity(String amenity) {
			this.amenity = amenity;
		}

		public int getNoOfRooms() {
			return noOfRooms;
		}

		public void setNoOfRooms(int noOfRooms) {
			this.noOfRooms = noOfRooms;
		}

		public int getRent() {
			return rent;
		}

		public void setRent(int rent) {
			this.rent = rent;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public String toString() {
			return "RoomType [typeId=" + typeId + ", roomName=" + roomName + ", bedCapacity=" + bedCapacity
					+ ", amenity=" + amenity + ", noOfRooms=" + noOfRooms + ", rent=" + rent + "]";
		}

		
		
}
