package com.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        System.out.println( "Hello World!" );
//        List<A> aList = new ArrayList<>();
//        Method method = aList.getClass().getMethod("add", Object.class);
//        System.out.println(method);
//        method.invoke(aList, new B());
//        System.out.println(aList.size());
//        A a = new A();
//        System.out.println(a);
        I i = (I) Proxy.newProxyInstance(App.class.getClassLoader(), new Class[]{I.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("proxy...");
                return null;
            }
        });
        i.test();

    }
}


interface I {
    void test();
}


class A {

}

class B {

}