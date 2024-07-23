package com.testPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testPortal.mapper.UserMapper;
import com.testPortal.model.User;

@Service
public class UserServImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User findByEmail(String email, String userType) {
		switch (userType.toLowerCase()) {
		case "admin":
			return userMapper.findAdminByEmail(email);
		case "student":
			return userMapper.findStudentByEmail(email);
		case "instructor":
			return userMapper.findInstructorByEmail(email);
		default:
			return null;
		}
	}
}
