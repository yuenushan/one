package com.example.study.spring.bean.controller;

import com.example.study.spring.bean.service.IServiceA;
import org.springframework.stereotype.Component;

@Component
public class ControllerA {
    private IServiceA serviceA;

    public ControllerA(IServiceA serviceA) {
        this.serviceA = serviceA;
    }

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
