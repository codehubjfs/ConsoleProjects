package com.bus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bus.model.Booking;
import com.bus.model.CustomersNew;

import jakarta.servlet.http.HttpServletRequest;

@Service
public interface PaymentService {

	void payAmount(String upi, String paymentMethod,String paymentstatus, List<Booking> book);
}
