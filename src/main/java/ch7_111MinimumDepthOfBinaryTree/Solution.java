package ch7_111MinimumDepthOfBinaryTree;

public class Solution {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        if (root != null && (root.left == null && root.right != null) || (root.left != null && root.right == null))
            return 1 + Math.max(minDepth(root.left), minDepth(root.right));

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

}
