package com.example.random;

import com.example.tree.TreeNode;

public class L129 {

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        sumNumbers(root, new StringBuilder());
        return sum;
    }

    private void sumNumbers(TreeNode root, StringBuilder chain) {
        if (root == null) {
            return;
        }
        chain.append(root.val);
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(chain.toString());
        } else {
            sumNumbers(root.left, chain);
            sumNumbers(root.right, chain);
        }
        chain.deleteCharAt(chain.length() - 1);
    }
}
