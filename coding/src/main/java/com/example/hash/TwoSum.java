package com.example.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int otherNum = target - nums[i];
            if (map.containsKey(otherNum)) {
                Integer otherIndex = map.get(otherNum);
                if (otherIndex != i) {
                    return new int[]{i, otherIndex};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
