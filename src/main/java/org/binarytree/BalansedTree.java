package org.binarytree;

public class BalansedTree {
        private static boolean isTreeBalanced = true;

        public static boolean isBalanced(TreeNode root) {
            getHeight(root);
            return isTreeBalanced;
        }

        private static int getHeight(TreeNode node) {
            if (node == null) return 0;

            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);

            if (Math.abs(leftHeight - rightHeight) > 1) {
                isTreeBalanced = false;
            }

            return 1 + Math.max(leftHeight, rightHeight);
        }

        public static void main(String [] arg){
            var root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(2);

            root.left.left = new TreeNode(3);
            root.left.right = new TreeNode(3);

            root.left.left.left = new TreeNode(4);
            root.left.left.right = new TreeNode(4);

            System.out.println(isBalanced(root));
        }

    }

    // root = [1,2,2,3,3,null,null,4,4]