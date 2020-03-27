package com.example.array;

public class ReverseWords3 {
    public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            stringBuilder.append(new StringBuilder(split[i]).reverse()).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords3().reverseWords("Let's take LeetCode contest"));
    }
}
