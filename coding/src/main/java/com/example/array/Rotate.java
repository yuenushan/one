package com.example.array;

import java.util.Arrays;

public class Rotate {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums,0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5,6,7};
        int[] nums = {-1};
        new Rotate().rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}
