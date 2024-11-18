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
    int preorderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return tree(preorder, inorder, 0, inorder.length-1);
    }

    private TreeNode tree(int[]preorder , int[]inorder , int inorderStart, int inorderEnd){
        if(inorderStart > inorderEnd){
            return null;
        }

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        int inorderIndex = findInorderIndex(inorder, rootValue, inorderStart, inorderEnd);

        root.left = tree(preorder, inorder, inorderStart , inorderIndex -1);
        root.right= tree(preorder, inorder, inorderIndex+1, inorderEnd);

        return root;
    }

    private int findInorderIndex(int[]array, int value,int start, int end){
        for(int i = start; i <= end; i++){
            if(array[i]== value){
                return i;
            }
        }
        return -1;
    }
}