package com.example.boot.graphqljava.datafetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

@Component
public class HelloDataFetcher {
    public DataFetcher<String> hello() {
        return new DataFetcher<String>() {
            @Override
            public String get(DataFetchingEnvironment environment) throws Exception {
                return "hello";
            }
        };
    }
}
