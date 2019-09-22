package com.example.study.spring.bean.service.impl;

import com.example.study.spring.bean.service.IServiceA;

public class ServiceAImpl implements IServiceA {
    @Override
    public void hello(String name) {
        System.out.println("hello " + name);
    }
}
