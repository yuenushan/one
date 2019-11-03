package com.example.stack;

import java.util.ArrayDeque;

public class MinStack {

    private ArrayDeque<Integer> mainStack = new ArrayDeque<>();
    private ArrayDeque<Integer> minStack = new ArrayDeque<>();

    public Integer pop() {
        minStack.pop();
        return mainStack.pop();
    }

    public void push(Integer val) {
        mainStack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, getMin()));
        }

    }

    public Integer getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(4);
        minStack.push(1);
        minStack.push(2);
        minStack.push(-1);
        minStack.push(5);
        System.out.println(minStack.getMin());
        System.out.println(minStack.pop());
        System.out.println(minStack.pop());
        System.out.println(minStack.getMin());
    }
}
