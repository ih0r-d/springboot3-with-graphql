package com.example.controller;

import com.example.exceptions.ApplianceNotFoundException;
import graphql.GraphQLError;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class CommonControllerAdvice {

    @GraphQlExceptionHandler
    public GraphQLError applianceNotFoundHandler(ApplianceNotFoundException e){
        return GraphQLError.newError()
                .message(e.getMessage())
                .build();
    }


}
