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
    public int closestValue(TreeNode root, double target) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);

        int closest = inorder.get(0);
        double minDiff = Math.abs(inorder.get(0) - target);

        for(int val: inorder){
            double diff = Math.abs(val - target);
            if(diff < minDiff){
                minDiff = diff;
                closest = val;
            }
        }
        return closest;
    }

    private void inorderTraversal(TreeNode node, List<Integer> inorder){
        if(node == null){
            return;
        }

        inorderTraversal(node.left, inorder);
        inorder.add(node.val);
        inorderTraversal(node.right, inorder);
    }
}