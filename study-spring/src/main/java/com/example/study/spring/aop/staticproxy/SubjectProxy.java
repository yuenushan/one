package com.example.study.spring.aop.staticproxy;

public class SubjectProxy implements ISubject{

    private ISubject subject;

    public SubjectProxy(ISubject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("this is " + this.getClass().getSimpleName());
        subject.request();
    }
}
