package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    static final int MAXIMUM_CAPACITY = 1 << 30;

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue( true );
    }

    @Test
    public void testThread() {
        int threads = 9;
        ThreadLocal<String> demo = new ThreadLocal<>();
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            Thread thread = new Thread(() -> {
                demo.set(Thread.currentThread().getName());
                System.out.println(demo.get());
                countDownLatch.countDown();
            }, "thread - " + i);
            thread.start();
        }
    }

    @Test
    public void testThread2() {
        int threads = 9;
        MyThreadLocal<String> myThreadLocal = new MyThreadLocal<>();
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            Thread thread = new Thread(() -> {
                myThreadLocal.set(Thread.currentThread().getName());
                System.out.println(myThreadLocal.get());
                countDownLatch.countDown();
            }, "thread - " + i);
            thread.start();
        }
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    @Test
    public void test3() {
        Map<String, String> map = new HashMap<>(4);
        map.put("1", "1");
//        for (int i = 0; i < 1000; i++) {
//            map.put(String.valueOf(i), String.valueOf(i));
//        }
//        int h;
//        h = (h = "abc".hashCode()) ^ (h >>> 16);
//        System.out.println(Integer.toBinaryString(h));
//        System.out.println(Collections.singletonList("hello") instanceof ParameterizedType);
//        System.out.println(map.getClass().getGenericInterfaces()[0] instanceof ParameterizedType);
//        ParameterizedType t = (ParameterizedType) map.getClass().getGenericInterfaces()[0];
//        System.out.println(t.getRawType());
//        System.out.println(t.getActualTypeArguments()[0]);
//        System.out.println(t.getOwnerType());

//        System.out.println(HashMap.class.getGenericInterfaces()[0]);


//        Field[] fields = ParameterizedBean.class.getDeclaredFields();
//        for(Field f:fields){
//            //是否是ParameterizedType
//            System.out.println(f.getName()+ ":" + f.getGenericType() + ":"+(f.getGenericType() instanceof ParameterizedType));
//        }
    }
}



class ParameterizedBean {
    List<String> list1;
    List list2;
    Map<String,Long> map1;
    Map map2;
    Map.Entry<Long,Short> map3;
}