package com.example.tree.searchtree;

import com.example.tree.TreeNode;

import java.util.Stack;

public class BSTIterator {

    private TreeNode root;
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.root = root;
        this.stack = new Stack<>();
    }

    /** @return the next smallest number */
    public int next() {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
        if (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            root = node.right;
            return node.val;
        }
        return -1;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return root != null || !stack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        BSTIterator obj = new BSTIterator(root);
        while (obj.hasNext()) {
            System.out.println(obj.next());
        }
    }
}
