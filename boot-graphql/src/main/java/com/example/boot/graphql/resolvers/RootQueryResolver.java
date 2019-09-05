package com.example.boot.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.boot.graphql.entity.Drug;
import com.example.boot.graphql.entity.Regimen;
import com.example.boot.graphql.entity.User;
import com.example.boot.graphql.exception.MyGraphQLException;
import com.example.boot.graphql.mapper.DrugMapper;
import com.example.boot.graphql.mapper.RegimenMapper;
import com.example.boot.graphql.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public Regimen regimen(String name) {
        return regimenMapper.findByName(name);
    }

    public List<Regimen> regimens() {
        return regimenMapper.findAll();
    }

    public List<Drug> drugs() {
        return drugMapper.findAll();
    }

    public Drug drug(String name) {
        return drugMapper.findByName(name);
    }

}

