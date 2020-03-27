package com.example.search;

public class SearchRotateArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[left]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        [4,5,6,7,0,1,2]
//        0
//        int[] nums = {4,5,6,7,8,1,2,3};
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(new SearchRotateArray().search(nums, target));
    }
}
