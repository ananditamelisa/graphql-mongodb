package com.tech.stuff.graphQLDemo.input;

import com.tech.stuff.graphQLDemo.model.NotificationSubscription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInput {

    private String email;
    private String phoneNumber;
    private List<NotificationSubscription> subscriptions;
}
