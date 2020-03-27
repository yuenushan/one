package com.example.random;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, 0, nums.length - 1, target);
    }

    private int searchInsert(int[] nums, int left, int right, int target) {
        if (left > right) {
            return left;
        }
        int mid = (left + right) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            return searchInsert(nums, left, mid - 1, target);
        } else {
            return searchInsert(nums, mid + 1, right, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(new SearchInsert().searchInsert(new int[]{1, 3, 5, 6}, 5));
    }
}
