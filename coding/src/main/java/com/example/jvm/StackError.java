package com.example.jvm;

public class StackError {

    private int recursive = 0;
    private int threadNum = 0;

    /**
     * -Xss256k
     */
    public void makeStackOverFlowError() {
        recursive++;
        makeStackOverFlowError();
    }

    public void makeStackOutOfMemoryError() {
        while (true) {
            threadNum++;
            new Thread(() -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        StackError stackError = new StackError();
//        try {
//            stackError.makeStackOverFlowError();
//        } catch (Throwable t) {
//            t.printStackTrace();
//            System.out.println("递归" + stackError.recursive + "层");
//        }
        try {
            stackError.makeStackOutOfMemoryError();
        } catch (Throwable t) {
            System.out.println("创建了" + stackError.threadNum + "个线程!");
            throw t;
        }
    }
}
