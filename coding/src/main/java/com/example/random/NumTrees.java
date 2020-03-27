package com.example.random;

public class NumTrees {

    private int[] table;

    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        table = new int[n + 1];
        return numTreesCore(n);
    }

    private int numTreesCore(int n) {
        if (n <= 1) {
            return 1;
        }
        if (table[n] == 0) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += numTreesCore(i) * numTreesCore(n - i - 1);
            }
            table[n] = sum;
        }
        return table[n];
    }

//    public int numTrees(int n) {
//        if (n <= 0) {
//            return 0;
//        }
//        return numTrees(1, n);
//    }
//
//    private int numTrees(int from, int to) {
//        if (from >= to) {
//            return 1;
//        }
//        int sum = 0;
//        for (int i = from; i <= to; i++) {
//            int leftTreeSize = numTrees(from, i - 1);
//            int rightTreeSize = numTrees(i + 1, to);
//            sum += leftTreeSize * rightTreeSize;
//        }
//        return sum;
//    }

    public static void main(String[] args) {
        System.out.println(new NumTrees().numTrees(3));
    }
}
