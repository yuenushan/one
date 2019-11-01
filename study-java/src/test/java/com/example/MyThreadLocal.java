package com.example;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyThreadLocal <T> {

    private Map<Thread, T> map = new ConcurrentHashMap<>();

    public void set(T value) {
        Thread t = Thread.currentThread();
        map.put(t, value);
    }

    public T get() {
        return map.get(Thread.currentThread());
    }
}
