package com.tech.stuff.graphQLDemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "NOTIFICATION_USER")
public class NotificationUser {

    @Id
    private ObjectId id;
    private String email;
    private String phoneNumber;
    private List<NotificationSubscription> subscriptions;
}
