package com.example.search;

public class FindMin {
    // 4,5,6,7,0,1,2
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (right == 1) {
                return nums[0];
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid-1]) {
                return nums[mid];
            } else {
                if (nums[mid] > nums[right - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 2, 3, 4};
        System.out.println(new FindMin().findMin(nums));
    }
}
