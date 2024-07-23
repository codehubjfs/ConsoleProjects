package com.ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.mapper.CardMapper;
import com.ticket.model.BookingBean;
import com.ticket.model.Bus;
import com.ticket.model.Customer;
import com.ticket.model.RoutesBean;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardMapper cardMapper;

    public List<Customer> viewCustomer() {
        return cardMapper.viewCustomer();
    }

	@Override
	public List<RoutesBean> getAllRoutes() {
		 return cardMapper.getAllRoutes();
	}

	@Override
	public List<Bus> getAllBus() {
		return cardMapper.getAllBus();
	}

	@Override
	public List<BookingBean> getAllBooking() {
		return cardMapper.getAllBooking();
	}
}