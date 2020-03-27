package com.example.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class SymmetricTree {
//    // 递归
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        return isSymmetric(root.left, root.right);
//    }
//
//    private boolean isSymmetric(TreeNode left, TreeNode right) {
//        if (left == null && right == null) {
//            return true;
//        }
//        if (left == null || right == null || left.val != right.val) {
//            return false;
//        }
//        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
//    }

    // 迭代
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            Queue<TreeNode> queue1 = new ArrayDeque<>();
            Queue<TreeNode> queue2 = new ArrayDeque<>();
            queue1.offer(root.left);
            queue2.offer(root.right);
            while (!queue1.isEmpty()) {
                TreeNode node1 = queue1.poll();
                TreeNode node2 = queue2.poll();
                if (node1.val != node2.val) {
                    return false;
                }
                if (node1.left != null && node2.right != null) {
                    queue1.offer(node1.left);
                    queue2.offer(node2.right);
                } else if (node1.left != null || node2.right != null) {
                    return false;
                }
                if (node1.right != null && node2.left != null) {
                    queue1.offer(node1.right);
                    queue2.offer(node2.left);
                } else if (node1.right != null || node2.left != null) {
                    return false;
                }
            }
            return true;
        } else if (root.left == null && root.right == null) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        System.out.println(new SymmetricTree().isSymmetric(root));
    }
}
