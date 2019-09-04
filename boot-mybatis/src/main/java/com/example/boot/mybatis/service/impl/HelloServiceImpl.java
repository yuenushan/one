package com.example.boot.mybatis.service.impl;

import com.example.boot.mybatis.mapper.UserMapper;
import com.example.boot.mybatis.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String hello() {
        return "hello " + userMapper.find(1).getName();
    }
}
