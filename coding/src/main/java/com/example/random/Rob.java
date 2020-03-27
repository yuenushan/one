package com.example.random;

import com.example.tree.TreeNode;

public class Rob {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int amount1 = root.val;
        if (root.left != null) {
            amount1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            amount1 += rob(root.right.left) + rob(root.right.right);
        }
        int amount2 = rob(root.left) + rob(root.right);
        return Math.max(amount1, amount2);
    }
}
