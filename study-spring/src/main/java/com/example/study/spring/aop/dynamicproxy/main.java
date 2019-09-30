package com.example.study.spring.aop.dynamicproxy;

import com.example.study.spring.aop.ISubject;
import com.example.study.spring.aop.SubjectImpl;

import java.lang.reflect.Proxy;

public class main {
    public static void main(String[] args) {
        ISubject subject = new SubjectImpl();
        ISubject proxy = (ISubject) Proxy.newProxyInstance(
                subject.getClass().getClassLoader(),
                new Class[]{ISubject.class},
                new RequestInvocationHandler(subject)
        );
        proxy.request();
    }
}
