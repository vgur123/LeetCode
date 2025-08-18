package org.binarytree;

public class PreOrPostOrede {

    public static void preOrderTraversal(Node root) {
        if (root == null) return;

        // Visit the root node
        //System.out.print(root.data + " ");

        // Traverse the left subtree
        preOrderTraversal(root.left);

        // Traverse the right subtree
        preOrderTraversal(root.right);

        // Visit the root node
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        // Create the following binary tree
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(51);
        root.right.right = new Node(6);
        root.right.right.right = new Node(61);

        System.out.print("Pre-Order Traversal: ");
        preOrderTraversal(root);
        System.out.println();
    }
}