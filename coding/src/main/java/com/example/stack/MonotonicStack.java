package com.example.stack;

import java.util.Arrays;
import java.util.Stack;

public class MonotonicStack {

    /**
     * 不包含重复元素
     * @param arr
     * @return
     */
    public static int[][] getMinPosition(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[][] result = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            while (true) {
                if (stack.isEmpty()) {
                    stack.push(i);
                    result[i][0] = -1;
                    break;
                } else {
                    if (arr[i] > arr[stack.peek()]) {
                        result[i][0] = stack.peek();
                        stack.push(i);
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        Stack<Integer> stack2 = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (true) {
                if (stack2.isEmpty()) {
                    stack2.push(i);
                    result[i][1] = -1;
                    break;
                } else {
                    if (arr[i] > arr[stack2.peek()]) {
                        result[i][1] = stack2.peek();
                        stack2.push(i);
                        break;
                    } else {
                        stack2.pop();
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 5, 6, 2, 7};
        System.out.println(Arrays.deepToString(getMinPosition(arr)));
    }
}
