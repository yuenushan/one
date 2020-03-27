package com.example.dp;

public class Knapsack01 {

//    private int[][] table;
//
//    public int knapsack01(int[] w, int[] v, int c) {
//        table = new int[w.length][c + 1];
//        for (int i = 0; i < table.length; i++) {
//            for (int j = 0; j < table[0].length; j++) {
//                table[i][j] = -1;
//            }
//        }
//        return knapsack01(w, v, w.length - 1, c);
//    }
//
////    private int knapsack01(int[] w, int[] v, int index, int c) {
////        if (index < 0 || c <= 0) {
////            return 0;
////        }
////        if (table[index][c] == -1) {
////            table[index][c] = Math.max(knapsack01(w, v, index - 1, c), v[index] + knapsack01(w, v, index - 1, c - w[index]));
////        }
////        return table[index][c];
////    }
//
//    private int knapsack01(int[] w, int[] v, int index, int c) {
//        if (index < 0 || c <= 0) {
//            return 0;
//        }
//        for (int i = 0; i <= c; i++) {
//            table[0][i] = w[0] <= i ? v[0]: 0;
//        }
//        for (int i = 1; i <= index; i++) {
//            for (int j = 0; j <= c; j++) {
//                table[i][j] = table[i - 1][j];
//                if (j >= w[i]) {
//                    table[i][j] = Math.max(table[i - 1][j], v[i] + table[i - 1][j - w[i]]);
//                }
//            }
//        }
//        return table[index][c];
//    }

    private int[] table;

    public int knapsack01(int[] w, int[] v, int c) {
        table = new int[c + 1];
        for (int i = 0; i < table.length; i++) {
            table[i] = -1;
        }
        return knapsack01(w, v, w.length - 1, c);
    }

//    private int knapsack01(int[] w, int[] v, int index, int c) {
//        if (index < 0 || c <= 0) {
//            return 0;
//        }
//        if (table[index][c] == -1) {
//            table[index][c] = Math.max(knapsack01(w, v, index - 1, c), v[index] + knapsack01(w, v, index - 1, c - w[index]));
//        }
//        return table[index][c];
//    }

    private int knapsack01(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0) {
            return 0;
        }
        for (int i = 0; i <= c; i++) {
            table[i] = w[0] <= i ? v[0]: 0;
        }
        for (int i = 1; i <= index; i++) {
            for (int j = c; j >= 0; j--) {
                if (j >= w[i]) {
                    table[j] = Math.max(table[j], v[i] + table[j - w[i]]);
                }
            }
        }
        return table[c];
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        System.out.println(new Knapsack01().knapsack01(w, v, 5));
    }
}
