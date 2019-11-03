package com.example.stack;

import java.util.ArrayDeque;

/**
 * 目前的实现复杂度较高，有更好的实现
 */
public class SortedStack {

    public static void sort(ArrayDeque<Integer> stack) {
        ArrayDeque<Integer> helperStack = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            int originSize = stack.size();
            Integer maxValue = getAndRemoveMaxValue(stack, helperStack);
            for (int i = 0; i < originSize - stack.size(); i++) {
                helperStack.push(maxValue);
            }
        }
        while (!helperStack.isEmpty()) {
            stack.push(helperStack.pop());
        }
    }

    public static Integer getAndRemoveMaxValue(ArrayDeque<Integer> stack, ArrayDeque<Integer> helperStack) {
        if (stack.isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        int maxValue = Integer.MIN_VALUE;
        int size = stack.size();
        while (!stack.isEmpty()) {
            Integer value = stack.pop();
            maxValue = Math.max(maxValue, value);
            helperStack.push(value);
        }
        for (int i = 0; i < size; i++) {
            Integer value = helperStack.pop();
            if (!value.equals(maxValue)) {
                stack.push(value);
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(2);
        stack.push(6);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(1);
        stack.push(4);
        System.out.println(stack);
        sort(stack);
        System.out.println(stack);
    }


}
