package com.springproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class RoomType {
	private int type_id;
    private String room_name;
    private int bed_capacity;
    private String amenity;
    private int no_of_room;
    private int rent;
}
