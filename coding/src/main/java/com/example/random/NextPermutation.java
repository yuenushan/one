package com.example.random;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int right = nums.length - 1;
        int left = right - 1;
        while (left >= 0 && left < right && nums[left] >= nums[right]) {
            right--;
            if (left >= right) {
                left--;
                right = nums.length - 1;
            }
        }
        if (left < 0) {
            Arrays.sort(nums);
            return;
        }
        swap(nums, left, right);
        Arrays.sort(nums, left + 1, nums.length);
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        NextPermutation runner = new NextPermutation();
        int[] nums = {4,2,0,2,3,2,0};
        for (int i = 0; i < 1; i++) {
            runner.nextPermutation(nums);
            System.out.println(Arrays.toString(nums));
        }
    }
}
