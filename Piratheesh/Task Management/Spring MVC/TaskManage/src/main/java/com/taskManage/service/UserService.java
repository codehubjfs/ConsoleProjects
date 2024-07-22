package com.taskManage.service;

import com.taskManage.model.UserModel;

public interface UserService {
    UserModel findByEmail(String email, String password, String usertype);
}

