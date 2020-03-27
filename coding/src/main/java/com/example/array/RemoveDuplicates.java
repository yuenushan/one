package com.example.array;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        int lastVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != lastVal) {
                nums[++index] = nums[i];
                lastVal = nums[i];
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
