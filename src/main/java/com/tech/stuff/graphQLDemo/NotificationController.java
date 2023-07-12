package com.tech.stuff.graphQLDemo;
import com.tech.stuff.graphQLDemo.input.UserInput;
import com.tech.stuff.graphQLDemo.model.NotificationUser;
import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class NotificationController {

    private GraphQL graphQL;
    private GraphQLUtility graphQlUtility;
    @Autowired
    NotificationController(GraphQLUtility graphQlUtility) throws IOException {
        this.graphQlUtility = graphQlUtility;
        graphQL = graphQlUtility.createGraphQlObject();
    }

    @PostMapping(value = "/query")
    public ResponseEntity query(@RequestBody String query){
        ExecutionResult result = graphQL.execute(query);
        System.out.println("errors: "+result.getErrors());
        return ResponseEntity.ok(result.getData());
    }

    @MutationMapping
    public NotificationUser saveBook(@Argument UserInput book) {
        //eturn bookService.updateBook(id, book);
        return null;
    }
}
