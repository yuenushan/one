package com.example.tree;

public class PathSumTree {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (isLeaf(root)) {
            return root.val == sum;
        } else if (root == null) {
            return false;
        } else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
