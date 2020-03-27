package com.example.array;

public class DominantIndex {
    public int dominantIndex(int[] nums) {
        int maxIndex = 0;
        boolean isDoubleMax = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                isDoubleMax = nums[i] >= 2 * nums[maxIndex];
                maxIndex = i;
            } else if (nums[maxIndex] < nums[i] * 2){
                isDoubleMax = false;
            }
        }
        if (isDoubleMax) {
            return maxIndex;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 0};
        System.out.println(new DominantIndex().dominantIndex(nums));
    }
}
