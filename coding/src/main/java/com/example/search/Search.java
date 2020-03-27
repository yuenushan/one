package com.example.search;

public class Search {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length, target);
    }

    private int search(int[] nums, int left, int right, int target) {
        if (left >= right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] > target) {
            return search(nums, left, mid, target);
        } else if (nums[mid] < target) {
            return search(nums, mid + 1, right, target);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] nums = {100};
        System.out.println(new Search().search(nums, 9));
        System.out.println(new Search().search(nums, 2));
    }
}
