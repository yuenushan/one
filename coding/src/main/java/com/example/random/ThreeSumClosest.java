package com.example.random;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < 3; i++) {
            res += nums[i];
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int newTarget = target - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                res = updateRes(res, sum + nums[i], target);
                if (sum < newTarget) {
                    left++;
                } else if (sum > newTarget) {
                    right--;
                } else {
                    return target;
                }
            }
        }
        return res;
    }

    private int updateRes(int oldRes, int newRes, int target) {
        return Math.abs(oldRes - target) < Math.abs(newRes - target) ? oldRes: newRes;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, 1));
    }
}
