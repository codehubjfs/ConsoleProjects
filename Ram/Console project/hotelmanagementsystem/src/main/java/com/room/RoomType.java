package com.room;

public class RoomType {
	private  int type_id;
	private String type_name;
	private TypeRoom room_type;
	private int room_capacity;
	private String amenity;
	private int pricePerNight;
	public RoomType(int type_id, TypeRoom room_type, int room_capacity, String amenity, int pricePerNight) {
		super();
		this.type_id = type_id;
		this.room_type = room_type;
		this.room_capacity = room_capacity;
		this.amenity = amenity;
		this.pricePerNight = pricePerNight;
	}
	public RoomType() {
		// TODO Auto-generated constructor stub
	}
	public RoomType(String tname, int rcapacity, String amenities, int price) {
		// TODO Auto-generated constructor stub
		this.type_name= tname;
		this.room_capacity = rcapacity;
		this.amenity = amenities;
		this.pricePerNight = price;
	}
	public RoomType(int type_id2, String typeName, int roomCapacity, String amenities, int pricePerNight2) {
		this.type_id=type_id2;
		this.type_name=typeName;
		this.room_capacity=roomCapacity;
		this.amenity=amenities;
		this.pricePerNight=pricePerNight2;
	}
	public  int getType_id() {
		return type_id;
	}
	public  void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public TypeRoom getRoom_type() {
		return room_type;
	}
	public void setRoom_type(TypeRoom room_type) {
		this.room_type = room_type;
	}
	public int getRoom_capacity() {
		return room_capacity;
	}
	public void setRoom_capacity(int room_capacity) {
		this.room_capacity = room_capacity;
	}
	public String getAmenity() {
		return amenity;
	}
	public void setAmenity(String amenity) {
		this.amenity = amenity;
	}
	public int getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(int pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	

}
