package com.example.dp;

public class ClimbStairs {

    private int[] table;

    public int climbStairs(int n) {
        table = new int[n + 1];
        return climbStairsCore(n);
    }

    private int climbStairsCore(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        table[0] = 1;
        table[1] = 1;
        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(3));
    }
}
