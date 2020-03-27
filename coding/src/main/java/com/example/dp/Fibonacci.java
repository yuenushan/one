package com.example.dp;

public class Fibonacci {

    private int[] table;

//    public int fib(int n) {
//        if (n == 0 || n == 1) {
//            return n;
//        }
//        if (table[n] == 0) {
//            table[n] = fib(n - 1) + fib(n - 2);
//        }
//        return table[n];
//    }

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        table = new int[n + 1];
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }

    public static void main(String[] args) {
        int n = 0;
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(n));
    }
}
