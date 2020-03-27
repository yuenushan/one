package com.example.tree;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right != null) {
            return right;
        }
        if (left != null && right == null) {
            return left;
        }
        if (left == null && right == null) {
            return null;
        }
        return root;
    }
}
