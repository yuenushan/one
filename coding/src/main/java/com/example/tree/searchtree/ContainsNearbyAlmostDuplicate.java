package com.example.tree.searchtree;

import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = treeSet.ceiling((long) nums[i]);
            Long floor = treeSet.floor((long) nums[i]);
            if ((ceiling != null && ceiling - nums[i] <= t) || (floor != null && nums[i] - floor <= t)) {
                return true;
            }
            treeSet.add((long) nums[i]);
            if (treeSet.size() > k) {
                treeSet.remove((long)nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int []nums = {-1,2147483647};
        int k = 1, t = 2147483647;
        System.out.println(new ContainsNearbyAlmostDuplicate().containsNearbyAlmostDuplicate(nums, k, t));
    }
}
