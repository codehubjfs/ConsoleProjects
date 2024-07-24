package com.hallbookingmanagement.mapper;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.hallbookingmanagement.beans.Booking;

@Repository
public interface BookingMapper {
	List<Booking> getAllBookings();
	int addBooking (Booking book);
	int updateBooking(Booking book);
	Booking selectBookingById(int bookingId);
}
