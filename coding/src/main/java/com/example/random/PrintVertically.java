package com.example.random;

import java.util.Arrays;
import java.util.List;

public class PrintVertically {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int maxWordLength = 0;
        for (String word : words) {
            maxWordLength = Math.max(maxWordLength, word.length());
        }
        String[] result = new String[maxWordLength];
        for (int i = 0; i < maxWordLength; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String word : words) {
                char c = word.length() > i ? word.charAt(i): ' ';
                stringBuilder.append(c);
            }
            result[i] = rtrim(stringBuilder.toString());
        }
        return Arrays.asList(result);
    }

    private String rtrim(String s) {
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if (s.charAt(i) != ' ') {
                return s.substring(0, i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "CONTEST IS COMING";
        System.out.println(new PrintVertically().printVertically(s));
    }
}
