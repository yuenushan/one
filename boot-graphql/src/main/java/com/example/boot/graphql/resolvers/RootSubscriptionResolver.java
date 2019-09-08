package com.example.boot.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.example.boot.graphql.entity.Drug;
import com.example.boot.graphql.publisher.DrugPublisher;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;

@Component
public class RootSubscriptionResolver implements GraphQLSubscriptionResolver {

    @Autowired
    private DrugPublisher drugPublisher;

    public Publisher<String> testSubscription(String arg) {
        return Flux.interval(Duration.ofSeconds(2)).map(i -> arg + Instant.now().toString());
    }

    public Publisher<Drug> drugsSubscription() {
        return drugPublisher.getPublisher();
    }
}
