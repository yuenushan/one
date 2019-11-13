package com.example.stack;

import java.util.ArrayDeque;

public class MaxMinValueArray {

    public static int getMaxMinCount(int[] arr, int num) {
        return 0;
    }

    private static void maxOp(ArrayDeque<Integer> maxDequeue, int[] arr, int j) {
        if (maxDequeue.isEmpty()) {
            maxDequeue.addLast(j);
        } else {
            if (maxDequeue.peekLast() == j) {
                return;
            }
            if (arr[j] <= arr[maxDequeue.peekLast()]) {
                maxDequeue.addLast(j);
            } else {
                maxDequeue.pollLast();
                maxOp(maxDequeue, arr, j);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 6, 4};
        int num = 2;
        System.out.println(getMaxMinCount(arr, num));
    }

}
