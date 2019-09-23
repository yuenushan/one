package com.example.study.spring.bean.service.impl;

import com.example.study.spring.bean.service.IServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServiceBImpl implements IServiceB {

    private String name;

    public String getName() {
        return name;
    }

    @Value("${name}")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String whoami() {
        return name;
    }
}
