package com.carrentalsystemspring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Car {
	private int car_id;
    private String car_name;
    private String vehicle_no;
    private String available;
    private int rental_rate;
    private int seat_count;
    private String fuel_type;
    private String car_type;
    private int bags;
    private String car_image_url;
    
   
    


}
