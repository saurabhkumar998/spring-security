package com.demo.springsecurityclient.event.listener;

import com.demo.springsecurityclient.entity.User;
import com.demo.springsecurityclient.event.RegistrationCompleteEvent;
import com.demo.springsecurityclient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;
import java.util.logging.Logger;

public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
   private UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // create the verification token for the user with link

        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);

        // send mail to user
        String url = event.getApplicationUrl() + "verifyRegistration?token="+token;

        System.out.println( "Click the link to verify your account : " + url);
    }

}
