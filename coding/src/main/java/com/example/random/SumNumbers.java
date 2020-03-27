package com.example.random;

import com.example.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumNumbers {

    public int sumNumbers(TreeNode root) {
        List<List<Integer>> paths = getPaths(root);
        return sum(paths);
    }

    private List<List<Integer>> getPaths(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        if (root.left == null && root.right == null) {
            List<Integer> path = new ArrayList<>();
            path.add(root.val);
            paths.add(path);
            return paths;
        }
        List<List<Integer>>  leftPaths = getPaths(root.left);
        List<List<Integer>>  rightPaths = getPaths(root.right);
        for (List<Integer> leftPath : leftPaths) {
            leftPath.add(0, root.val);
            paths.add(leftPath);
        }
        for (List<Integer> rightPath : rightPaths) {
            rightPath.add(0, root.val);
            paths.add(rightPath);
        }
        return paths;
    }

    private int sum(List<List<Integer>> paths) {
        int sum = 0;
        for (List<Integer> path : paths) {
            sum += convert(path);
        }
        return sum;
    }

    private int convert(List<Integer> path) {
        int num = 0;
        for (Integer val : path) {
            num = num * 10 + val;
        }
        return num;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new SumNumbers().sumNumbers(root));
    }
}
