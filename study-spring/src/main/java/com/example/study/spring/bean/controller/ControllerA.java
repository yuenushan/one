package com.example.study.spring.bean.controller;

import com.example.study.spring.bean.service.IServiceA;
import com.example.study.spring.bean.service.IServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControllerA {
    private IServiceA serviceA;
    private IServiceB serviceB;

    public ControllerA(IServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public IServiceB getServiceB() {
        return serviceB;
    }

    @Autowired
    public void setServiceB(IServiceB serviceB) {
        this.serviceB = serviceB;
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

    public String whoami() {
        return serviceB.whoami();
    }
}
