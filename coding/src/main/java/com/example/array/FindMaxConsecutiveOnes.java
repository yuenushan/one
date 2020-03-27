package com.example.array;

public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = 0;
        int lastPosition = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, i - lastPosition - 1);
                lastPosition = i;
            }
        }
        return Math.max(maxConsecutiveOnes, nums.length - lastPosition - 1);
    }

    public static void main(String[] args) {
        System.out.println(new FindMaxConsecutiveOnes().findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }
}
