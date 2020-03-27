package com.example.tree;

import java.util.*;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        if (strings.length == 0) {
            return null;
        }
        Queue<String> queue = new ArrayDeque<>();
        for (String string : strings) {
            queue.offer(string);
        }
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue) {
        String val = queue.poll();
        TreeNode root = null;
        if (!"#".equals(val)) {
            root = new TreeNode(Integer.valueOf(val));
            root.left = deserialize(queue);
            root.right = deserialize(queue);
        }
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(codec.serialize(root));
        System.out.println(codec.serialize(codec.deserialize(codec.serialize(root))));
    }
}
