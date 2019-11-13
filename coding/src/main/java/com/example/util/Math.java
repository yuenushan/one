package com.example.util;

public class Math {

    /**
     * 用辗转相除法求最大公约数
     * @param a
     * @param b
     * @return
     */
    public static int greatestCommonDivisor(int a, int b) {
        if (a == 0 || b== 0) {
            return 0;
        }
        int divisor = java.lang.Math.abs(a);
        int dividend = java.lang.Math.abs(b);
        while (divisor % dividend != 0) {
            int tmp = divisor;
            divisor = dividend;
            dividend = tmp % dividend;
        }
        return dividend;
    }

    public static void main(String[] args) {
        System.out.println(greatestCommonDivisor(24, 36));
    }
}
