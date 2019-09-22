package com.example.study.spring.bean.controller;

import com.example.study.spring.bean.service.IServiceA;

public class ControllerA {
    private IServiceA serviceA;

    public IServiceA getServiceA() {
        return serviceA;
    }

    public void setServiceA(IServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public void hello(String name) {
        serviceA.hello(name);
    }
}
