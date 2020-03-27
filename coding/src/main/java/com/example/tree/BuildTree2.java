package com.example.tree;

public class BuildTree2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        BuildTree2 buildTree2 = new BuildTree2();
        TreeNode treeNode = buildTree2.buildTree(preorder, inorder);
        System.out.println(new InorderTraversal().inorderTraversal(treeNode));
    }
}
