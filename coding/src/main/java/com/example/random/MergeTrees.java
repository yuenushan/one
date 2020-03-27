package com.example.random;

import com.example.tree.TreeNode;

public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root;
        if (t1 != null && t2 != null) {
            root = t1;
            t1.val += t2.val;
            TreeNode leftNode = mergeTrees(t1.left, t2.left);
            TreeNode rightNode = mergeTrees(t1.right, t2.right);
            root.left = leftNode;
            root.right = rightNode;
        } else if (t1 == null) {
            root = t2;
        } else {
            root = t1;
        }
        return root;
    }
}
