package com.demo.springsecurityclient.controller;

import com.demo.springsecurityclient.entity.User;
import com.demo.springsecurityclient.event.RegistrationCompleteEvent;
import com.demo.springsecurityclient.model.UserModel;
import com.demo.springsecurityclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel) {

        User user = userService.registerUser(userModel);

        publisher.publishEvent(new RegistrationCompleteEvent(user, "url"));

        return "Success";
    }
}
