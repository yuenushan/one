package com.example.dp;

public class HouseRobber {

    private int[] table;

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        table = new int[nums.length];
        for (int i = 0; i < table.length; i++) {
            table[i] = -1;
        }
        return doRob(nums, nums.length - 1);
    }

    private int doRob(int[] nums, int n) {
        if (n == 0) {
            return nums[0];
        }
        if (n == 1) {
            return Math.max(nums[0], nums[1]);
        }
        table[0] = nums[0];
        table[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i <= n; i++) {
            table[i] = Math.max(nums[i] + table[i - 2], table[i - 1]);
        }
        return table[n];
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{3, 4, 1, 2}));
        System.out.println(new HouseRobber().rob(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }
}
