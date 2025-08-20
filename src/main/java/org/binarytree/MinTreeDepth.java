package org.binarytree;

public class MinTreeDepth {

    static int minDepth(TreeNode root){
        if (root == null) return 0;

        if (root.left == null && root.right == null) return 1;

        if (root.left == null)
            return minDepth(root.right) + 1;

        if (root.right == null)
            return minDepth(root.left) + 1;

        return Math.min(minDepth(root.left),
                minDepth(root.right)) + 1;
    }


        public static void main(String [] arg){
            var root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(2);

            root.left.left = new TreeNode(3);
            root.left.right = new TreeNode(3);

            root.left.left.left = new TreeNode(4);
            root.left.left.right = new TreeNode(4);

            System.out.println(minDepth(root));
        }

    }
    