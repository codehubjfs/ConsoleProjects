package com.bus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bus.model.Booking;
import com.bus.model.Bus;
import com.bus.model.Payment;




@Service
public interface BookingService {
        List<Booking> bookSeats(int customerId, int busId, int routeId, String boardingPoint, String droppingPoint,
                       List<Integer> seatNumber, double totalPrice, String bookingStatus);

		List<Booking> bookingList();

		List<Booking> getAllBooking();
		
		List<Bus> getAllBus();
		
		List<Payment> getAllpayment();

		void cancelBooking(int bookingId);

		Booking getBookingById(int bookingId);

		
        
      

    }



