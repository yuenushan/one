package com.example.boot.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;

@Component
public class RootSubscriptionResolver implements GraphQLSubscriptionResolver {

    public Publisher<String> testSubscription(String arg) {
        return Flux.interval(Duration.ofSeconds(2)).map(i -> arg + Instant.now().toString());
    }
}
