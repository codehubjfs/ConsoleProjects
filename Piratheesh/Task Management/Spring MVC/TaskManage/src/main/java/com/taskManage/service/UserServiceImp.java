package com.taskManage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskManage.mapper.UserMapper;
import com.taskManage.model.UserModel;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;
    
    @Override
    public UserModel findByEmail(String email, String password, String usertype) {
        return userMapper.getEmployee(email, password, usertype);
    }
}
