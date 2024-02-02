package com.demo.springsecurityclient.event;

import com.demo.springsecurityclient.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

public class RegistrationCompleteEvent extends ApplicationEvent {

    private User user;
    private String applicationUrl;
    public RegistrationCompleteEvent(User user, String applicationUrl) {
        super(user);

        this.user = user;
        this.applicationUrl = applicationUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getApplicationUrl() {
        return applicationUrl;
    }

    public void setApplicationUrl(String applicationUrl) {
        this.applicationUrl = applicationUrl;
    }
}
