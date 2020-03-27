package com.example.random;

import com.example.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFBT {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> result = new ArrayList<>();
        if (N == 1) {
            result.add(new TreeNode(0));
        } else if (N % 2 == 1) {
            for (int i = 0; i < N - 1; i++) {
                List<TreeNode> leftTrees = allPossibleFBT(i);
                List<TreeNode> rightTrees = allPossibleFBT(N - i - 1);
                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree : rightTrees) {
                        TreeNode root = new TreeNode(0);
                        root.left = leftTree;
                        root.right = rightTree;
                        result.add(root);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodes = new AllPossibleFBT().allPossibleFBT(7);
        System.out.println(treeNodes.size());
    }

}
