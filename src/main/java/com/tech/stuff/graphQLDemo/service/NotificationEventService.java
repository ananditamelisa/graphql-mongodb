package com.tech.stuff.graphQLDemo.service;

import com.tech.stuff.graphQLDemo.model.NotificationEvent;
import com.tech.stuff.graphQLDemo.repository.NotificationEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationEventService {

    @Autowired
    private NotificationEventRepository repository;

    public List<NotificationEvent> findAllUserSubscriptionEvents (List<String> eventCodes) {
        return repository.findByEventCodeIn(eventCodes);
    }
}
