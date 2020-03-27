package com.example.random;

import java.util.*;

public class LetterCombinations {

    private static final String[] keywords = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        letterCombinations(digits, 0, new StringBuilder(), res);
        return res;
    }

    private void letterCombinations(String digits, int index, StringBuilder stringBuilder, ArrayList<String> res) {
        if (digits.isEmpty()) {
            return;
        }
        if (digits.length() <= index) {
            res.add(stringBuilder.toString());
            return;
        }
        String keyword = keywords[digits.charAt(index) - '0'];
        for (int i = 0; i < keyword.length(); i++) {
            stringBuilder.append(keyword.charAt(i));
            letterCombinations(digits, index + 1, stringBuilder, res);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("239"));
    }
}
