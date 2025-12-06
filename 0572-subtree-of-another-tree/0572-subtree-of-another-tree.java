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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        String full = preOrder(root);
        String part = preOrder(subRoot);

        return (full.contains(part));
    }

    public String preOrder(TreeNode node){
        if(node == null) return "null";

        StringBuilder sb = new StringBuilder("^");

        sb.append(node.val);
        sb.append(preOrder(node.left));
        sb.append(preOrder(node.right));

        return sb.toString();
    }
}