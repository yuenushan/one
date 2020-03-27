package com.example.random;

import com.example.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int from, int to) {
        List<TreeNode> result = new ArrayList<>();
        if (from == to) {
            result.add(new TreeNode(from));
        } else {
            for (int i = from; i <= to; i++) {
                List<TreeNode> leftTrees = generateTrees(from, i - 1);
                List<TreeNode> rightTrees = generateTrees(i + 1, to);
                if (leftTrees.size() == 0) {
                    for (TreeNode rightTree : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.right = rightTree;
                        result.add(root);
                    }
                } else if (rightTrees.size() == 0) {
                    for (TreeNode leftTree : leftTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftTree;
                        result.add(root);
                    }
                } else {
                    for (TreeNode leftTree : leftTrees) {
                        for (TreeNode rightTree : rightTrees) {
                            TreeNode root = new TreeNode(i);
                            root.left = leftTree;
                            root.right = rightTree;
                            result.add(root);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodes = new GenerateTrees().generateTrees(3);
        System.out.println(treeNodes.size());
    }
}
