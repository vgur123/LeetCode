package org.binarytree;

public class MaxTreeDepth {
    public static int maxDepth(TreeNode root) {
        // Base case: if the root is null, the depth is 0.
        if (root == null) {
            return 0;
        }

        // Recursively calculate the depth of the left and right subtrees.
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // The maximum depth of the current tree is 1 (for the current node)
        // plus the maximum of the left and right subtree depths.

        return 1 + Math.max(leftDepth, rightDepth);
    }


        public static void main(String [] arg){
            var root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(2);

            root.left.left = new TreeNode(3);
            root.left.right = new TreeNode(3);

            root.left.left.left = new TreeNode(4);
            root.left.left.right = new TreeNode(4);

            System.out.println(maxDepth(root));
        }

    }
