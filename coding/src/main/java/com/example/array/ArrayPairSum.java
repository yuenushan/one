package com.example.array;

import java.util.Arrays;

public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            sum += nums[i*2];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new ArrayPairSum().arrayPairSum(new int[]{1, 4, 3, 2}));
    }
}
