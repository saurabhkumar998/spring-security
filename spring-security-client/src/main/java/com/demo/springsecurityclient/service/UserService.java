package com.demo.springsecurityclient.service;

import com.demo.springsecurityclient.entity.User;
import com.demo.springsecurityclient.model.UserModel;
import org.springframework.stereotype.Service;


public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
