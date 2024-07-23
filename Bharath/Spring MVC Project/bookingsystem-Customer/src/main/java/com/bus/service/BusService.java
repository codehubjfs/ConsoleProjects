package com.bus.service;
import java.time.LocalDate;
import java.util.List;

import com.bus.model.Bus;

public interface BusService {

	List<Bus> getBusList();
	List<Bus> searchBuses(String startlocation, String endlocation, LocalDate travelDate);

}

