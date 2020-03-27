package com.example.random;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        dict.sort(Comparator.comparingInt(String::length));
        String[] strings = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            for (String s : dict) {
                if (strings[i].startsWith(s)) {
                    strings[i] = s;
                }
            }
            stringBuilder.append(strings[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(new ReplaceWords().replaceWords(dict, sentence));
    }
}
