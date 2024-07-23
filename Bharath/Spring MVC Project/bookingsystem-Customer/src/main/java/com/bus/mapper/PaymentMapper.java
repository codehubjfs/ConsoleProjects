package com.bus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.bus.model.Booking;
import com.bus.model.Payment;

public interface PaymentMapper {
	@Select("select * from Paymentcustomer")
	@Results({
        @Result(property="pay_id", column="pay_id"),
        @Result(property="accountNumber", column="accountNumber"),
        @Result(property="paymentMethod", column="paymentMethod"),
        @Result(property="totalAmount", column="totalAmount"),
        @Result(property="book.bookingid", column="booking_id"),
        @Result(property="paymentStatus", column="paymentStatus"),
        @Result(property="bus.busid",column="bus_id")
    })
	List<Payment> getAllpayment();
	
	@Insert("INSERT INTO paymentcustomer (pay_id, accountNumber, paymentMethod, totalAmount, booking_id, paymentStatus) " +
            "VALUES (PAYMENTCUSTOMER_SEQ.NEXTVAL, #{accountNumber}, #{paymentMethod}, #{totalAmount}, #{booking.bookingid}, #{paymentStatus})")
    
    void insertPayment(@Param("accountNumber") String accountNumber,
                       @Param("paymentMethod") String paymentMethod,
                       @Param("totalAmount") double totalAmount,
                       @Param("booking") Booking booking,
                       @Param("paymentStatus") String paymentStatus);
}

