package com.tech.stuff.graphQLDemo.repository;

import com.tech.stuff.graphQLDemo.model.NotificationEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationEventRepository extends MongoRepository<NotificationEvent, String> {

    List<NotificationEvent> findByEventCodeIn(List<String> eventCodes);
}
