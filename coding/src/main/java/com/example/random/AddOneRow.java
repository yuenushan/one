package com.example.random;

import com.example.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class AddOneRow {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        if (root != null) {
            queue1.offer(root);
        }
        while (!queue1.isEmpty()) {
            d--;
            while (!queue1.isEmpty()) {
                TreeNode node = queue1.poll();
                if (d == 1) {
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    node.left = new TreeNode(v);
                    node.right = new TreeNode(v);
                    node.left.left = left;
                    node.right.right = right;
                }
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
        return root;
    }
}
