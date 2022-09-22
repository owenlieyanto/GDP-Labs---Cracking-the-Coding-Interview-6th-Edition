package com.gdp.Trees_and_Graphs;

import java.util.Random;

public class Trees_and_Graphs {
    public static void main(String[] args) {
        // try with Binary Tree
        TreeNode binaryTreeNode = TreeNode.makeBT(5, 1, 100);
        boolean isBST = checkBST(binaryTreeNode);
        System.out.println("Is binaryTreeNode BST? " + isBST);

        // try with Binary Search Tree
        TreeNode binarySearchTreeNode = new TreeNode();
        Random random = new Random();
        // insert i data for building BST
        for (int i = 0; i < 50; i++) {
            binarySearchTreeNode.insertBST(random.nextInt(100) + 1);
        }
        isBST = checkBST(binarySearchTreeNode);
        System.out.println("Is binarySearchTreeNode BST? " + isBST);
    }

    /**
     * check if a com.gdp.Trees_and_Graphs.TreeNode is a BST or not.
     * @param n target {@link TreeNode} to be checked.
     * @return boolean result.
     */
    static boolean checkBST(TreeNode n) {
        return checkBST(n, null, null);
    }

    /**
     * helper for checkBST main function.
     * @param n target {@link TreeNode} to be checked.
     * @param min int check for left node.
     * @param max int check for right node.
     * @return boolean result.
     */
    static boolean checkBST(TreeNode n, Integer min, Integer max) {
        // stopping condition
        if (n == null) {
            return true;
        }
        // if not meet BST rule
        if ((min != null && n.data <= min) || (max != null && n.data > max)) {
            return false;
        }
        // check node child
        if (checkBST(n.left, min, n.data)) {
            return checkBST(n.right, n.data, max);
        }
        return false;
    }

}
