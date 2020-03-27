package com.example.random;

import com.example.tree.TreeNode;

public class Flatten {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode rightTree = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode rightNode = root;
        while (rightNode.right != null) {
            rightNode = rightNode.right;
        }
        rightNode.right = rightTree;
        flatten(root.right);
    }

}
