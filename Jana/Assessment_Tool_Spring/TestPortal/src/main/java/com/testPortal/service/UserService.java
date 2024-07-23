package com.testPortal.service;

import com.testPortal.model.User;

public interface UserService {

	User findByEmail(String email, String userType);

}
