package com.example.random;

import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        if (n > 0) {
            generateParenthesis(n, n, new StringBuilder(), res);
        }
        return res;
    }

    private void generateParenthesis(int left, int right, StringBuilder stringBuilder, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(stringBuilder.toString());
        }
        if (left > 0) {
            generateParenthesis(left - 1, right, stringBuilder.append("("), res);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (left < right) {
            generateParenthesis(left, right - 1, stringBuilder.append(")"), res);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }
}
