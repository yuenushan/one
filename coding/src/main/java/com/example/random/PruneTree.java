package com.example.random;

import com.example.tree.TreeNode;

public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        if (isZeroTree(root)) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root;
    }

    private boolean isZeroTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val == 0) {
            return isZeroTree(root.left) && isZeroTree(root.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        root = new PruneTree().pruneTree(root);
        System.out.println(root);
    }
}
