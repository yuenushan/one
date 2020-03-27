package com.example.random;

import com.example.tree.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        return (p == null && q == null) || (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

}
