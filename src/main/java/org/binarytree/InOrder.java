package org.binarytree;

public class InOrder {
    public static void inOrderTraversal(Node root) {
        if (root == null) return;


        // Traverse the left subtree
        inOrderTraversal(root.left);

        // Visit the root node
        System.out.print(root.data + " ");

        // Traverse the right subtree
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(51);
        root.right.right = new Node(6);
        root.right.right.right = new Node(61);

        System.out.print("In-Order Traversal: ");
        inOrderTraversal(root);
        System.out.println();
    }

}
