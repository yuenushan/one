package com.example.boot.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.boot.graphql.entity.Drug;
import com.example.boot.graphql.entity.Regimen;
import com.example.boot.graphql.entity.User;
import com.example.boot.graphql.exception.MyGraphQLException;
import com.example.boot.graphql.mapper.DrugMapper;
import com.example.boot.graphql.mapper.RegimenMapper;
import com.example.boot.graphql.mapper.UserMapper;
import graphql.relay.Connection;
import graphql.relay.SimpleListConnection;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RootQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RegimenMapper regimenMapper;
    @Autowired
    private DrugMapper drugMapper;

    public String hello(Integer id) {
        User user = userMapper.find(id);
        if (user == null) {
            throw new MyGraphQLException(String.format("id=%d的用户不存在!", id));
        } else {
            return "hello " + user.getName();
        }
    }

    public Object testScalar(String text) {
        return text;
    }

    public Connection<User> users(int first, int last, String before, String after, DataFetchingEnvironment env) {
        return new SimpleListConnection<>(Arrays.asList(
                new User(1, "Luke"),
                new User(2, "david"),
                new User(3, "jack")
        )).get(env);
    }

    public Regimen regimen(String name) {
        return regimenMapper.findByName(name);
    }

    public Connection<Regimen> regimens(int first, String after, DataFetchingEnvironment env) {
        return new SimpleListConnection<>(regimenMapper.findAll()).get(env);
    }

    public Connection<Drug> drugs(int first, String after, DataFetchingEnvironment env) {
        return new SimpleListConnection<>(drugMapper.findAll()).get(env);
    }

    public Drug drug(String name) {
        return drugMapper.findByName(name);
    }

}
