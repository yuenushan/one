package com.example.study.spring.aop.staticproxy;

public class SubjectImpl implements ISubject {
    @Override
    public void request() {
        System.out.println("this is " + this.getClass().getSimpleName());
    }
}
