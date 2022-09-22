package com.gdp.Trees_and_Graphs;

import java.util.Random;

public class TreeNode {
    public int data;
    public TreeNode root, left, right;

    public TreeNode() {
    }

    TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    static Random random = new Random();

    /**
     *
     *
     * @param height height of the tree
     * @return com.gdp.Trees_and_Graphs.TreeNode head as Binary Tree
     */

    /**
     * make a Binary Tree with specified height.
     * @param height height of the tree
     * @param min min int data
     * @param max max int data
     * @return root of binary tree node.
     */
    static TreeNode makeBT(int height, int min, int max) {
        // stopping condition
        if (height == 0) {
            return null;
        }

        // generate data
        int data = random.nextInt(max - min + 1) + min;

        TreeNode node = new TreeNode(data);

        // generate 0 / 1 / 2 child
        int numChild = random.nextInt(3);

        if (numChild == 0) {    // if 0 child
            return node;
        } else if (numChild == 1) { // if 1 child
            // pick left / right randomly
            int leftOrRight = random.nextInt(2);

            if (leftOrRight == 0) { // 0 means left
                node.left = makeBT(height - 1, min, max);
            } else {    // 1 means right
                node.right = makeBT(height - 1, min, max);
            }
            return node;
        } else {    // if 2 child
            node.left = makeBT(height - 1, min, max);
            node.right = makeBT(height - 1, min, max);
            return node;
        }
    }

    /**
     * insert new node according to BST rule.
     * @param data int.
     */
    public void insertBST(int data) {
        root = insert_Recursive(root, data);
    }

    /**
     * helper for insertBST function.
     * @param root root node.
     * @param data int.
     * @return tree node root after insertion.
     */
    private TreeNode insert_Recursive(TreeNode root, int data) {
        // tree is empty
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        // traverse the tree
        if (data < root.data)     // insert in the left subtree
            root.left = insert_Recursive(root.left, data);
        else if (data > root.data)    // insert in the right subtree
            root.right = insert_Recursive(root.right, data);

        // return pointer
        return root;
    }
}
