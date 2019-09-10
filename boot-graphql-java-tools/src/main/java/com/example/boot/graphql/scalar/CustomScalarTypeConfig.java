package com.example.boot.graphql.scalar;

import graphql.language.StringValue;
import graphql.schema.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomScalarTypeConfig {

    @Bean
    public GraphQLScalarType uuidScalarType() {
        return GraphQLScalarType.newScalar().name("TEST").coercing(new Coercing() {
            @Override
            public Object serialize(Object dataFetcherResult) throws CoercingSerializeException {
                return dataFetcherResult + "OUT";
            }

            @Override
            public Object parseValue(Object input) throws CoercingParseValueException {
                return input + "IN";
            }

            @Override
            public Object parseLiteral(Object input) throws CoercingParseLiteralException {
                if (input instanceof StringValue) {
                    String possibleValue = ((StringValue) input).getValue();
                    return possibleValue + "IN2";
                }
                throw new CoercingParseLiteralException(
                        "Value is invalid : '" + String.valueOf(input) + "'"
                );
            }
        }).build();
    }
}
