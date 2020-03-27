package com.example.tree.searchtree;

import com.example.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ValidBST {

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i+1) <= list.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(new ValidBST().isValidBST(root));
    }
}
