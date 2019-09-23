package com.example.study.spring.beanfactory;

import com.example.study.spring.bean.controller.ControllerA;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.example.study.spring.bean");
        ControllerA controllerA = (ControllerA) context.getBean("controllerA");
        controllerA.hello("ioc");
        System.out.println(controllerA.whoami());
    }
}
