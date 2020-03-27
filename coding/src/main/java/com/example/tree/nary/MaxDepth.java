package com.example.tree.nary;

import java.util.ArrayList;

public class MaxDepth {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null) {
            return 1;
        }
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child));
        }
        return max + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.children = new ArrayList<>();
        Node node = new Node(3);
        root.children.add(node);
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        node.children = new ArrayList<>();
        node.children.add(new Node(5));
        node.children.add(new Node(6));
        System.out.println(new MaxDepth().maxDepth(root));
    }
}
