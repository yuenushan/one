package com.example.tree.nary;

import java.util.ArrayList;
import java.util.List;

public class Postorder {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            for (Node child : root.children) {
                postorder(child, result);
            }
        }
        result.add(root.val);
    }
}
