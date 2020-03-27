package com.example.random;

import com.example.tree.TreeNode;

public class FindTilt {
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        int abs;
        if (root.left == null) {
            abs = Math.abs(sum(root.right));
        } else if (root.right == null) {
            abs = Math.abs(sum(root.left));
        } else {
            abs = Math.abs(sum(root.left) - sum(root.right));
        }
        int leftTilt = findTilt(root.left);
        int rightTilt = findTilt(root.right);
        return abs + leftTilt + rightTilt;
    }

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val;
        sum += sum(root.left) + sum(root.right);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        System.out.println(new FindTilt().findTilt(root));
    }
}
