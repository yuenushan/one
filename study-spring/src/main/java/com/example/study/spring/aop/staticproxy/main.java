package com.example.study.spring.aop.staticproxy;

import com.example.study.spring.aop.ISubject;
import com.example.study.spring.aop.SubjectImpl;

public class main {
    public static void main(String[] args) {
        ISubject subject = new SubjectProxy(new SubjectImpl());
        subject.request();
    }
}
