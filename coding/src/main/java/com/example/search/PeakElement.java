package com.example.search;

public class PeakElement {

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length - 1 || nums[mid] > nums[mid+1])) {
                return mid;
            } else {
                if (mid == 0 || nums[mid] < nums[mid-1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(new PeakElement().findPeakElement(nums));
    }
}
