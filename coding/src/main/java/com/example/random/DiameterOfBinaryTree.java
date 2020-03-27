package com.example.random;

import com.example.tree.TreeNode;

import java.util.Stack;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int maxLength = 0;
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            maxLength = Math.max(maxLength, diameterLength(node));
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return maxLength;
    }

    private int diameterLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return maxLengthPath(root.left) + maxLengthPath(root.right);
    }

    private int maxLengthPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxLengthPath(root.left), maxLengthPath(root.right));
    }
}
