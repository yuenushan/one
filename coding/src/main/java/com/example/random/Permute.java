package com.example.random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length != 0) {
            permute(nums, new boolean[nums.length], new ArrayList<>(), res);
        }
        return res;
    }

    private void permute(int[] nums, boolean[] selected, List<Integer> prefix, List<List<Integer>> res) {
        if (nums.length == prefix.size()) {
            res.add(new ArrayList<>(prefix));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!selected[i]) {
                prefix.add(num);
                selected[i] = true;
                permute(nums, selected, prefix, res);
                prefix.remove(prefix.size() - 1);
                selected[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permute().permute(new int[]{1, 2, 3}));
    }
}
