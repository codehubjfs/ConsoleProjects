package com.room;

import com.person.Customer;

public class Room {
	private int type_id;
    private int roomNo;
    private int roomPrice;
    private RoomCondition room_condition;
    private RoomStatus room_status;
    private String housekeeping_request;
	public Room(int type_id, int roomNo, int roomPrice, RoomCondition room_condition, RoomStatus room_status) {
		//super();
		this.type_id = type_id;
		this.roomNo = roomNo;
		this.roomPrice = roomPrice;
		this.room_condition = room_condition;
		this.room_status = room_status;
	}
	public Room()
	{
		
	}

	public Room(int typeId, int roomNo2, RoomCondition roomCondition, RoomStatus roomStatus) {
		this.type_id=typeId;
		this.roomNo=roomNo2;
		this.room_condition = roomCondition;
		this.room_status=roomStatus;
	}
	public Room(int roomNo2, RoomStatus roomStatus, RoomCondition roomCondition, String housekeepingRequest) {
		this.roomNo=roomNo2;
		this.room_status = roomStatus;
		this.room_condition=roomCondition;
		this.housekeeping_request=housekeepingRequest;
	}
	public String getHousekeeping_request() {
		return housekeeping_request;
	}
	public void setHousekeeping_request(String housekeeping_request) {
		this.housekeeping_request = housekeeping_request;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public int getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}
	public RoomCondition getRoom_condition() {
		return room_condition;
	}
	public void setRoom_condition(RoomCondition room_condition) {
		this.room_condition = room_condition;
	}
	public RoomStatus getRoom_status() {
		return room_status;
	}
	public void setRoom_status(RoomStatus room_status) {
		this.room_status = room_status;
	}
   
//    private int room_no;
	
		
	
}
