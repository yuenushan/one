package com.example;

import java.util.LinkedHashMap;
import java.util.Map;

public class Test {

    static class LRU extends LinkedHashMap {

        private int maxSize;

        public LRU(int maxSize) {
            this.maxSize = maxSize;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > maxSize;
        }
    }

    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.put("a", 1);
        lru.put("b", 2);
        lru.put("a", 3);
        lru.put("c", 4);
        lru.put("d", 5);
        lru.forEach((key ,value) -> System.out.println(key + ": " + value));
    }
}
