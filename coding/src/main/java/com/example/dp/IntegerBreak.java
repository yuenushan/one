package com.example.dp;

public class IntegerBreak {

    private int[] table;

    public int integerBreak(int n) {
        table = new int[n + 1];
        return integerBreakCore(n);
    }

//    private int integerBreakCore(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        int max = 0;
//        if (table[n] == 0) {
//            for (int i = 1; i < n; i++) {
//                max = Math.max(Math.max(max, i * integerBreakCore(n - i)), i * (n - i));
//            }
//            table[n] = max;
//        }
//        return table[n];
//    }

    private int integerBreakCore(int n) {
        table[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(Math.max(max, j * table[i - j]), j * (i - j));
            }
            table[i] = max;
        }
        return table[n];
    }

    public static void main(String[] args) {
//        2124471432
        System.out.println(new IntegerBreak().integerBreak(100));
    }
}
