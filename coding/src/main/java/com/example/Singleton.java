package com.example;


public class Singleton implements Cloneable{
    private static volatile Singleton singleton;
    private Singleton() {}
    public static Singleton getInstance(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Singleton singleton = getInstance();
        Singleton singleton1 = (Singleton) singleton.clone();
        Singleton singleton2 = getInstance();
        System.out.println(singleton.hashCode());
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }
}