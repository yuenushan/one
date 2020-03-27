package com.example.random;

import com.example.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        if (root == null) {
            return result;
        }
        queue1.offer(root);
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        while (!queue1.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            result.add(0, row);
            while (!queue1.isEmpty()) {
                TreeNode node = queue1.poll();
                row.add(node.val);
                if (node.left != null) {
                    queue2.offer(node.left);
                }
                if (node.right != null) {
                    queue2.offer(node.right);
                }
            }
            Queue<TreeNode> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new LevelOrderBottom().levelOrderBottom(root));
    }
}
