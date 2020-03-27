package com.example.array;

public class ReverseWords {
    public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            stringBuilder.append(split[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWords runner = new ReverseWords();
        System.out.println(runner.reverseWords("the sky is blue"));
    }
}
