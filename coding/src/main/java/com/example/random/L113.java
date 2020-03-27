package com.example.random;

import com.example.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        pathSum(root, sum, new LinkedList<>(), res);
        return res;
    }

    private void pathSum(TreeNode root, int sum, LinkedList<Integer> prefix, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        prefix.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val && !prefix.isEmpty()) {
                res.add(new ArrayList<>(prefix));
            }
        } else {
            pathSum(root.left, sum - root.val, prefix, res);
            pathSum(root.right, sum - root.val, prefix, res);
        }
        prefix.removeLast();
    }

}
