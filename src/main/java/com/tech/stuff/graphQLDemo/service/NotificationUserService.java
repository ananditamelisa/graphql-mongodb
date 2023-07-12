package com.tech.stuff.graphQLDemo.service;

import com.tech.stuff.graphQLDemo.input.UserInput;
import com.tech.stuff.graphQLDemo.model.NotificationUser;
import com.tech.stuff.graphQLDemo.repository.NotificationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationUserService {

    @Autowired
    private NotificationUserRepository notificationUserRepository;

    public NotificationUser getUserById(String id) {
        return notificationUserRepository.findById(id).get();
    }

    public NotificationUser save (UserInput userInput) {
        NotificationUser notificationUser =
                NotificationUser.builder()
                        .email(userInput.getEmail())
                        .phoneNumber(userInput.getPhoneNumber())
                        .subscriptions(userInput.getSubscriptions())
                        .build();
        return notificationUserRepository.save(notificationUser);
    }

    public List<NotificationUser> getAllUsers(){
        return notificationUserRepository.findAll();
    }

    public NotificationUser save(NotificationUser user) {
        return notificationUserRepository.save(user);
    }
}
