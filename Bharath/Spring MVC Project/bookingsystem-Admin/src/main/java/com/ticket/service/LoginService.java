package com.ticket.service;

import com.ticket.model.Admin;

public interface LoginService {
	public Admin loginAsAdmin(String email, String password);
}
