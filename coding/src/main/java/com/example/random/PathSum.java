package com.example.random;

import com.example.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> path = new ArrayList<>();
            path.add(root.val);
            res.add(path);
            return res;
        }
        List<List<Integer>> leftPaths = pathSum(root.left, sum - root.val);
        for (List<Integer> leftPath : leftPaths) {
            leftPath.add(0, root.val);
            res.add(leftPath);
        }
        List<List<Integer>> rightPaths = pathSum(root.right, sum - root.val);
        for (List<Integer> rightPath : rightPaths) {
            rightPath.add(0, root.val);
            res.add(rightPath);
        }
        return res;
    }
}
