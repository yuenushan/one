package com.example.boot.graphql.dataloader;

import graphql.servlet.context.DefaultGraphQLContext;
import graphql.servlet.context.DefaultGraphQLServletContext;
import graphql.servlet.context.DefaultGraphQLWebSocketContext;
import graphql.servlet.context.GraphQLContext;
import graphql.servlet.context.GraphQLContextBuilder;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;
import java.util.List;

@Component
public class CustomGraphQLContextBuilder implements GraphQLContextBuilder {

    private DataLoaderRegistry registry;

    public CustomGraphQLContextBuilder(List<DataLoader<?, ?>> loaderList) {
        DataLoaderRegistry registry = new DataLoaderRegistry();
        for (DataLoader<?, ?> loader : loaderList) {
            registry.register(loader.getClass().getSimpleName(), loader);
        }
        this.registry = registry;
    }

    @Override
    public GraphQLContext build(HttpServletRequest req, HttpServletResponse response) {
        return DefaultGraphQLServletContext.createServletContext(registry, null).with(req).with(response).build();
    }

    @Override
    public GraphQLContext build() {
        return new DefaultGraphQLContext(registry, null);
    }

    @Override
    public GraphQLContext build(Session session, HandshakeRequest request) {
        return DefaultGraphQLWebSocketContext.createWebSocketContext(registry, null).with(session).with(request).build();
    }

}
