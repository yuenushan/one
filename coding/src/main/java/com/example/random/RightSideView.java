package com.example.random;

import com.example.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        if (root != null) {
            queue1.offer(root);
        }
        while (!queue1.isEmpty()) {
            TreeNode rightNode = null;
            while (!queue1.isEmpty()) {
                TreeNode poll = queue1.poll();
                if (poll.left != null) {
                    queue2.offer(poll.left);
                }
                if (poll.right != null) {
                    queue2.offer(poll.right);
                }
                rightNode = poll;
            }
            Queue<TreeNode> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
            res.add(rightNode.val);
        }
        return res;
    }
}
