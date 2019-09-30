package com.example.study.spring.aop.staticproxy;

public class main {
    public static void main(String[] args) {
        ISubject subject = new SubjectProxy(new SubjectImpl());
        subject.request();
    }
}
