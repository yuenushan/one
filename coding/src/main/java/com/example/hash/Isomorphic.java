package com.example.hash;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicCore(s, t) && isIsomorphicCore(t, s);
    }

    private boolean isIsomorphicCore(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(t.charAt(i))) {
                    return false;
                }
            } else {
                map.put(c, t.charAt(i));
            }
        }
        return true;
    }
}
