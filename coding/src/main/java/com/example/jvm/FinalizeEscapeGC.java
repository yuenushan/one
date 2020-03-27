package com.example.jvm;

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOCK = null;

    public void isAlive() {
        System.out.println("yes, i am still alive!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        SAVE_HOCK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOCK = new FinalizeEscapeGC();
        SAVE_HOCK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOCK != null) {
            SAVE_HOCK.isAlive();
            SAVE_HOCK = null;
            System.gc();
            Thread.sleep(500);
            if (SAVE_HOCK != null) {
                SAVE_HOCK.isAlive();
            } else {
                System.out.println("no, i am dead!");
            }
        } else {
            System.out.println("no, i am dead!");
        }
    }

}
