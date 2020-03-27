package com.example.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
//    // 先用递归的方式实现
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> traversalValues = new ArrayList<>();
//        preorderTraversal(root, traversalValues);
//        return traversalValues;
//    }
//
//    private void preorderTraversal(TreeNode root, List<Integer> traversalValues) {
//        if (root != null) {
//            traversalValues.add(root.val);
//            preorderTraversal(root.left, traversalValues);
//            preorderTraversal(root.right, traversalValues);
//        }
//    }

    // 迭代方式遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversalValues = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            traversalValues.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return traversalValues;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        System.out.println(preorderTraversal.preorderTraversal(root));
        System.out.println(preorderTraversal.preorderTraversal(null));
    }
}
