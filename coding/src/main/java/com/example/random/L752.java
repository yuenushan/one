package com.example.random;

import java.util.*;

public class L752 {

    private int minCount = -1;

    public int openLock(String[] deadends, String target) {
        Set<String> deadendsSet = new HashSet<>();
        deadendsSet.addAll(Arrays.asList(deadends));
        String source = "0000";
        if (source.equals(target)) {
            return 0;
        }
        openLock(deadendsSet, target, source, 0);
        return minCount;
    }

    private void openLock(Set<String> deadends, String target, String source, int count) {
        deadends.add(source);
        List<String> candidates = getCandidates(source);
        for (String candidate : candidates) {
            if (deadends.contains(candidate)) {
                continue;
            }
            if (candidate.equals(target)) {
                deadends.add(candidate);
                if (minCount == -1) {
                    minCount = count + 1;
                } else {
                    minCount = Math.min(minCount, count + 1);
                }
                continue;
            }
            openLock(deadends, target, candidate, count + 1);
        }
    }
    
    private List<String> getCandidates(String source) {
        List<String> candidates = new ArrayList<>();
        for (int i = 0; i < source.length(); i++) {
            int val1 = (source.charAt(i) - '0' + 1) % 10;
            candidates.add(source.substring(0, i) + val1 + source.substring(i + 1));
            int val2 = source.charAt(i) - '0' - 1;
            if (val2 == -1) {
                val2 = 9;
            }
            candidates.add(source.substring(0, i) + val2 + source.substring(i + 1));
        }
        return candidates;
    }

    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(new L752().openLock(deadends, target));
    }
}
