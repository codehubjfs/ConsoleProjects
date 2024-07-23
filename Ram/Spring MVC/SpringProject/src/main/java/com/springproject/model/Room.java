package com.springproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class Room {

	 private int room_Id;
	    private int type_Id;
	   
	    private String room_status;
	    private String room_condition;
}
