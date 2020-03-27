package com.example.array;

public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < s) {
            return 0;
        }
        int left = 0;
        sum = 0;
        int minLength = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= s) {
                do {
                    minLength = Math.min(minLength, i - left + 1);
                    sum -= nums[left];
                    left++;
                } while (sum >= s);
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        System.out.println(new MinSubArrayLen().minSubArrayLen(7, new int[]{2, 3, 7, 1, 2, 4, 3}));
    }
}
