/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0; // Base case: height of null node is 0
        }

        int leftHeight = checkHeight(node.left); // Check left subtree
        if (leftHeight == -1) return -1; // Propagate unbalanced state

        int rightHeight = checkHeight(node.right); // Check right subtree
        if (rightHeight == -1) return -1; // Propagate unbalanced state

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node is unbalanced
        }

        return Math.max(leftHeight, rightHeight) + 1; // Return height of current node
    }
}
