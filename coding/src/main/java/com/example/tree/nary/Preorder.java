package com.example.tree.nary;

import java.util.ArrayList;
import java.util.List;

public class Preorder {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                preorder(child, result);
            }
        }
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
        System.out.println(new Preorder().preorder(root));

    }
}
