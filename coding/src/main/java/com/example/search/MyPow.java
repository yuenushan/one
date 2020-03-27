package com.example.search;

public class MyPow {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int flag = n < 0 ? -1 : 1;
        double result = 1;
        for (int i = 0; i < flag * n; i++) {
            result *= x;
        }
        return flag == 1 ? result : 1 / result;
    }

    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(2.00000, -2));
    }
}
