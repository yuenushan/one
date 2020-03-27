package com.example.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
//    // 递归
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        inorderTraversal(root, result);
//        return result;
//    }
//
//    private void inorderTraversal(TreeNode root, List<Integer> result) {
//        if (root ==  null) {
//            return;
//        }
//        inorderTraversal(root.left, result);
//        result.add(root.val);
//        inorderTraversal(root.right, result);
//    }

    // 遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        do {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                result.add(node.val);
                root = node.right;
            }
        } while (!stack.isEmpty() || root != null);
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        InorderTraversal inorderTraversal = new InorderTraversal();
        System.out.println(inorderTraversal.inorderTraversal(root));
        System.out.println(inorderTraversal.inorderTraversal(null));
    }
}
