package com.tech.stuff.graphQLDemo.repository;

import com.tech.stuff.graphQLDemo.model.NotificationUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationUserRepository extends MongoRepository<NotificationUser, String> {

}
