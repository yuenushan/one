package com.example.random;

import java.util.Stack;

public class BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        return restore(S).equals(restore(T));
    }

    private String restore(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder newStr = new StringBuilder();
        while (!stack.isEmpty()) {
            newStr.append(stack.pop());
        }
        return newStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(new BackspaceCompare().backspaceCompare("ab#d", "ad#c"));
    }
}
