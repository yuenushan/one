package com.example.tree.nary;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue1 = new ArrayDeque<>();
        Queue<Node> queue2= new ArrayDeque<>();
        queue1.offer(root);
        while (!queue1.isEmpty()) {
            List<Integer> levelResult = new ArrayList<>();
            result.add(levelResult);
            while (!queue1.isEmpty()) {
                Node node = queue1.poll();
                levelResult.add(node.val);
                if (node.children != null) {
                    for (Node child : node.children) {
                        queue2.offer(child);
                    }
                }
            }
            Queue<Node> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }
        return result;
    }
}
