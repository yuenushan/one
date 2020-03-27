package com.example.random;

import com.example.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        findDuplicateSubtrees(root, res);
        return res;
    }

    private void findDuplicateSubtrees(TreeNode root, List<TreeNode> res) {
        if (root == null) {
            return;
        }
        List<TreeNode> leftNodes = getAllNodes(root.left);
        List<TreeNode> rightNodes = getAllNodes(root.right);
        for (TreeNode leftNode : leftNodes) {
            for (TreeNode rightNode : rightNodes) {
                if (isSameTree(leftNode, rightNode)) {
                    boolean isSame = false;
                    for (TreeNode node : res) {
                        if (isSameTree(node, leftNode)) {
                            isSame = true;
                        }
                    }
                    if (!isSame) {
                        res.add(leftNode);
                    }
                }
            }
        }
    }

    private List<TreeNode> getAllNodes(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        if (root != null) {
            stack1.push(root);
        }
        List<TreeNode> list1 = new ArrayList<>();
        while (!stack1.isEmpty()) {
            TreeNode pop1 = stack1.pop();
            list1.add(pop1);
            if (pop1.left != null) {
                stack1.push(pop1.left);
            }
            if (pop1.right != null) {
                stack1.push(pop1.right);
            }
        }
        return list1;
    }

    private void findDuplicateSubtrees(TreeNode p, TreeNode q, List<TreeNode> res) {
        if (isSameTree(p, q)) {
            res.add(p);
        }
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        return (p == null && q == null) || (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}
