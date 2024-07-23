package com.springproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class HouseKeeper {
	private int keeper_id;
    private String name;
    private String email;
    private String phone_no;
    private String password;
    private String status;

}
