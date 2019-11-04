package com.example.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MaxWindowArray {
    public static int[] getMaxWindowArray(int[] arr, int size) {
        if (arr == null || size < 1 || arr.length < size) {
            return null;
        }
        int[] maxWindowArray = new int[arr.length - size + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            handle(deque, arr, i, size);
            if (i + 1 >= size) {
                maxWindowArray[i+1-size] = arr[deque.peekFirst()];
            }
        }
        return maxWindowArray;
    }

    private static void handle(ArrayDeque<Integer> deque, int[] arr, int i, int size) {
        if (deque.isEmpty()) {
            deque.add(i);
        } else {
            if (arr[deque.peekLast()] >= arr[i]) {
                deque.addLast(i);
                if (deque.peekFirst() == i - size) {
                    deque.pollFirst();
                }
            } else {
                deque.pollLast();
                handle(deque, arr, i, size);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        System.out.println(Arrays.toString(getMaxWindowArray(arr, 3)));
    }
}
