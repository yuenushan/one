package com.example.boot.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.boot.graphql.entity.User;
import com.example.boot.graphql.exception.MyGraphQLException;
import com.example.boot.graphql.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private UserMapper userMapper;

    public String hello(Integer id) {
        User user = userMapper.find(id);
        if (user == null) {
            throw new MyGraphQLException(String.format("id=%d的用户不存在!", id));
        } else {
            return "hello " + user.getName();
        }
    }
}

