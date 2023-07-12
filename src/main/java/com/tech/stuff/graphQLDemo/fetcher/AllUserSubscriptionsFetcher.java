package com.tech.stuff.graphQLDemo.fetcher;

import com.tech.stuff.graphQLDemo.model.NotificationEvent;
import com.tech.stuff.graphQLDemo.model.NotificationSubscription;
import com.tech.stuff.graphQLDemo.model.NotificationUser;
import com.tech.stuff.graphQLDemo.service.NotificationEventService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AllUserSubscriptionsFetcher implements DataFetcher<List<NotificationEvent>> {
    @Autowired
    private NotificationEventService notificationEventService;

    @Override
    public List<NotificationEvent> get(DataFetchingEnvironment env) {
        NotificationUser user = env.getSource();
        List<String> eventCodes = new ArrayList<>();
        if(user!=null){
            eventCodes = user.getSubscriptions().stream()
                    .map(NotificationSubscription::getEventCode)
                    .collect(Collectors.toList());
        }
        List<NotificationEvent> result =
                notificationEventService.findAllUserSubscriptionEvents(eventCodes);
        return result;
    }
}
