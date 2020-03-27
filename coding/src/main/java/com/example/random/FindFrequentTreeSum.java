package com.example.random;

import com.example.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindFrequentTreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sumFreqMap = new HashMap<>();
        findTreeSum(root, sumFreqMap);
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : sumFreqMap.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sumFreqMap.entrySet()) {
            if (entry.getValue() == max) {
                res.add(entry.getKey());
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private int findTreeSum(TreeNode root, Map<Integer, Integer> sumFreqMap) {
        if (root == null) {
            return 0;
        }
        int leftTreeSum = findTreeSum(root.left, sumFreqMap);
        int rightTreeSum = findTreeSum(root.right, sumFreqMap);
        int sum = root.val + leftTreeSum + rightTreeSum;
        if (sumFreqMap.containsKey(sum)) {
            sumFreqMap.put(sum, sumFreqMap.get(sum) + 1);
        } else {
            sumFreqMap.put(sum, 1);
        }
        return sum;
    }
}
