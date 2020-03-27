package com.example.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class NodeFill {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue1 = new ArrayDeque<>();
        Queue<Node> queue2 = new ArrayDeque<>();
        queue1.offer(root);
        while (!queue1.isEmpty()) {
            Node lastNode = null;
            while (!queue1.isEmpty()) {
                Node node = queue1.poll();
                if (lastNode != null) {
                    lastNode.next = node;
                }
                lastNode = node;
                if (node.left != null) {
                    queue2.offer(node.left);
                }
                if (node.right != null) {
                    queue2.offer(node.right);
                }
            }
            Queue<Node> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
