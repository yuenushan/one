package com.example.stack;

import java.util.ArrayDeque;

public class ReverseStackByRecursion {
    /**
     * 仅用递归函数和栈操作逆序一个栈
     */

    public static void reverse(ArrayDeque<Integer> stack) {
        if (stack.size() > 1) {
            Integer bottomElement = getAndRemoveBottomElement(stack);
            reverse(stack);
            stack.push(bottomElement);
        }
    }

    public static Integer getAndRemoveBottomElement(ArrayDeque<Integer> stack) {
        if (stack.size() == 0) {
            return null;
        } else if (stack.size() == 1) {
            return stack.pop();
        } else {
            Integer val = stack.pop();
            Integer bottomElement = getAndRemoveBottomElement(stack);
            stack.push(val);
            return bottomElement;
        }
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }
}
