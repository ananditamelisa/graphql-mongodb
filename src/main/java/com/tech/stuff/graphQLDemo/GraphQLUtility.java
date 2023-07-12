package com.tech.stuff.graphQLDemo;

import com.tech.stuff.graphQLDemo.fetcher.AllNotificationUserFetcher;
import com.tech.stuff.graphQLDemo.fetcher.AllUserSubscriptionsFetcher;
import com.tech.stuff.graphQLDemo.fetcher.NotificationUserFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

import static graphql.GraphQL.newGraphQL;
import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

@Component
public class GraphQLUtility {
    @Value("classpath:schema.graphqls")
    private Resource schemaResource;
    private GraphQL graphQL;
    private AllNotificationUserFetcher allNotificationUserFetcher;
    private NotificationUserFetcher notificationUserFetcher;
    private AllUserSubscriptionsFetcher allUserSubscriptionEventFetcher;

    @Autowired
    GraphQLUtility(AllNotificationUserFetcher allNotificationUserFetcher, NotificationUserFetcher notificationUserFetcher,
                   AllUserSubscriptionsFetcher allUserSubscriptionEventFetcher) throws IOException {
        this.allNotificationUserFetcher = allNotificationUserFetcher;
        this.notificationUserFetcher = notificationUserFetcher;
        this.allUserSubscriptionEventFetcher = allUserSubscriptionEventFetcher;
    }

    @PostConstruct
    public GraphQL createGraphQlObject() throws IOException {
        File schemas = schemaResource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemas);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        return newGraphQL(schema).build();
    }

    public RuntimeWiring buildRuntimeWiring(){
        return newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("notificationUsers", allNotificationUserFetcher)
                        .dataFetcher("notificationUser", notificationUserFetcher))
                .type("NotificationUser", typeWiring -> typeWiring
                        .dataFetcher("eventTopics", allUserSubscriptionEventFetcher))
                .build();
    }
}
