package com.tech.stuff.graphQLDemo.fetcher;

import com.tech.stuff.graphQLDemo.service.NotificationUserService;
import com.tech.stuff.graphQLDemo.model.NotificationUser;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AllNotificationUserFetcher implements DataFetcher<List<NotificationUser>> {

    @Autowired
    private NotificationUserService notificationUserService;

    @Override
    public List<NotificationUser> get(DataFetchingEnvironment env) {
        System.out.println("DEBUG 1");
        NotificationUser user = env.getSource();
        List<NotificationUser> users = new ArrayList<>();
        users = notificationUserService.getAllUsers();
        return users;
    }
}
