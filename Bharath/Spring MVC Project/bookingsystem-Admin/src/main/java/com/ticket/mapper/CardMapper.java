package com.ticket.mapper;

import com.ticket.model.BookingBean;
import com.ticket.model.Bus;
import com.ticket.model.Customer;
import com.ticket.model.RoutesBean;
import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface CardMapper {
    @Select("SELECT * FROM route WHERE ROUTE_AVAILABILITY='Y'")
    List<RoutesBean> getAllRoutes();

    @Select("SELECT * FROM customer")
    List<Customer> viewCustomer();
    @Select("SELECT * FROM BUS")
	List<Bus> getAllBus();
    @Select("SELECT * FROM BOOK")
	List<BookingBean> getAllBooking();
}


