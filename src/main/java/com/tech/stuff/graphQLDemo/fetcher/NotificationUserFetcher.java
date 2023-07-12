package com.tech.stuff.graphQLDemo.fetcher;

import com.tech.stuff.graphQLDemo.model.NotificationUser;
import com.tech.stuff.graphQLDemo.service.NotificationUserService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NotificationUserFetcher implements DataFetcher<NotificationUser> {

    @Autowired
    private NotificationUserService notificationUserService;

    @Override
    public NotificationUser get(DataFetchingEnvironment env) {
        System.out.println("DEBUG 2");
        Map args = env.getArguments();
        NotificationUser user = notificationUserService.getUserById(String.valueOf(args.get("id")));
        return user;
    }
}
