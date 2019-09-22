package com.example.study.spring.bean.service.impl;

import com.example.study.spring.bean.service.IServiceA;
import org.springframework.stereotype.Service;

@Service
public class ServiceAImpl implements IServiceA {
    @Override
    public void hello(String name) {
        System.out.println("hello " + name);
    }
}
