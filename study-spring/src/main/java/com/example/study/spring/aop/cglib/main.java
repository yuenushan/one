package com.example.study.spring.aop.cglib;

import com.example.study.spring.aop.ISubject;
import com.example.study.spring.aop.SubjectImpl;
import org.springframework.cglib.proxy.Enhancer;

public class main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SubjectImpl.class);
        enhancer.setCallback(new RequestMethodInterceptor());
        ISubject subject = (ISubject) enhancer.create();
        subject.request();
    }
}
