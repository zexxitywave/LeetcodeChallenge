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
    public TreeNode sortedArrayToBST(int[] nums) {
        return bst(nums, 0, nums.length-1);
        
    }

    private TreeNode bst(int nums[], int start, int end){

        if(start > end){
            return null;
        }
        int points = start+(end - start)/2;

        TreeNode root = new TreeNode(nums[points]);

        root.left = bst(nums,start,points-1);
        root.right = bst(nums,points+1,end);

        return root;
    }
}