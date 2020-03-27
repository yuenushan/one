package com.example.search;

import java.util.Arrays;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;
        result[0] = searchLeft(nums, left, right, target);
        result[1] = result[0] == -1 ? -1 : searchRight(nums, result[0], right, target);
        return result;
    }

    private int searchLeft(int[] nums, int left, int right, int target) {
        int leftPos = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                leftPos = mid;
                right = mid - 1;
            }
        }
        return leftPos;
    }

    private int searchRight(int[] nums, int left, int right, int target) {
        int rightPos = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                rightPos = mid;
                left = mid + 1;
            }
        }
        return rightPos;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(new SearchRange().searchRange(nums, target)));
    }
}
