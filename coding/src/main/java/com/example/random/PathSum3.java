package com.example.random;

import com.example.tree.TreeNode;

public class PathSum3 {
    public int pathSum(TreeNode root, int sum) {
        return pathSum(root, sum, true);
    }

    private int pathSum(TreeNode root, int sum, boolean flag) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == sum) {
            res++;
        }
        if (flag) {
            res += pathSum(root.left, sum, true)
                    + pathSum(root.right, sum, true)
                    + pathSum(root.left, sum - root.val, false)
                    + pathSum(root.right, sum - root.val, false);
        } else {
            res += pathSum(root.left, sum - root.val, false)
                    + pathSum(root.right, sum - root.val, false);
        }
        return res;
    }
}
