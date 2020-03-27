package com.example.random;

import java.util.*;

public class UncommonFromSentences {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        put(map, A);
        put(map, B);
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        return result.toArray(new String[result.size()]);
    }

    private void put(Map<String, Integer> map, String sentence) {
        for (String str : sentence.split(" ")) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
    }

    public static void main(String[] args) {
        String A = "this apple is sweet";
        String B = "this apple is sour";
        System.out.println(Arrays.toString(new UncommonFromSentences().uncommonFromSentences(A, B)));
    }
}
