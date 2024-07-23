package com.bus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bus.model.Booking;
import com.bus.model.Routes;

@Mapper
public interface BookingMapper {

//    @Insert("INSERT INTO booking (customer_id,bookid,bus_id, route_id, boarding_point, dropping_point, seat_number, total_price,bookingStatus) " +
//            "VALUES (#{customer_id},booking_seq.NEXTVAL, #{routeId}, #{boardingPoint}, #{droppingPoint}, #{selectedSeats}, #{totalPrice},#{bookingStatus})")
//    void bookSeats(@Param("customerid") int customerId,
//    			   @Param("busId") int busId,
//                   @Param("routeId") int routeId,
//                   @Param("boardingPoint") String boardingPoint,
//                   @Param("droppingPoint") String droppingPoint,
//                   @Param("selectedSeats") List<Integer> selectedSeats,
//                   @Param("totalPrice") double totalPrice,
//    			   @Param("bookingStatus") String bookingStatus);
	 @Insert("INSERT INTO bookings (customer_id, bookid, busid, routeid, departure, arrival, selectedSeats, totalprice, bookingStatus) " +
	            "VALUES (#{customer.customer_id}, BOOKID_SEQS.NEXTVAL, #{bus.busid}, #{route.index}, #{boardingPoint}, #{droppingPoint}, #{selectedSeats}, #{totalPrice}, #{bookingStatus})")
	 @Options(useGeneratedKeys = true,keyProperty = "bookingid",keyColumn = "bookid")
	 void bookSeats(Booking booking);
	 
	 
	 

	
	//for fetching booking list
	@Select("select * from bookings")
	@Results({
        @Result(property="bookingid", column="bookid"),
        @Result(property="customer.customer_id", column="customer_id"),
        @Result(property="bus.busid", column="busid"),
        @Result(property="route.index", column="routeid"),
        @Result(property="totalPrice", column="totalprice"),
        @Result(property="selectedSeats", column="selectedseats"),
        @Result(property="boardingPoint", column="DEPARTURE"),
        @Result(property="droppingPoint", column="ARRIVAL"),
    })
	List<Booking> bookingList();

	 @Update("DELETE FROM bookings WHERE bookid = #{bookingId}")
	 void cancelBooking(int bookingId);




	 @Select("SELECT * FROM bookings WHERE bookid = #{bookingId}")
	 @Results({
	        @Result(property="bookingid", column="bookid"),
	        @Result(property="customer.customer_id", column="customer_id"),
	        @Result(property="bus.busid", column="busid"),
	        @Result(property="route.index", column="routeid"),
	        @Result(property="totalPrice", column="totalprice"),
	        @Result(property="selectedSeats", column="selectedseats"),
	        @Result(property="boardingPoint", column="DEPARTURE"),
	        @Result(property="droppingPoint", column="ARRIVAL"),
	    })
Booking getBookingById(int bookingId);
      
	
	
	
}
