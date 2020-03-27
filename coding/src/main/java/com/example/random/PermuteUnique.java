package com.example.random;

import java.util.*;

public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!countMap.containsKey(nums[i])) {
                countMap.put(nums[i], 0);
            }
            countMap.put(nums[i], countMap.get(nums[i]) + 1);
        }
        int[] newNums = new int[countMap.size()];
        int i = 0;
        for (Integer num: countMap.keySet()) {
            newNums[i++] = num;
        }
        permuteUnique(nums.length, newNums, countMap, new ArrayList<>(), res);
        return res;
    }

    private void permuteUnique(int size, int[] nums, Map<Integer, Integer> countMap, List<Integer> prefix, List<List<Integer>> res) {
        if (size == prefix.size()) {
             res.add(new ArrayList<>(prefix));
             return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (countMap.get(nums[i]) == 0) {
                continue;
            }
            countMap.put(nums[i], countMap.get(nums[i]) - 1);
            prefix.add(nums[i]);
            permuteUnique(size, nums, countMap, prefix, res);
            prefix.remove(prefix.size() - 1);
            countMap.put(nums[i], countMap.get(nums[i]) + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermuteUnique().permuteUnique(new int[]{1, 1, 2}));
    }
}
