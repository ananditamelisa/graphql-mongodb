package com.tech.stuff.graphQLDemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "NOTIFICATION_EVENT")
public class NotificationEvent {
    @Id
    private String id;
    private String eventCode;
    private String topic;
}
