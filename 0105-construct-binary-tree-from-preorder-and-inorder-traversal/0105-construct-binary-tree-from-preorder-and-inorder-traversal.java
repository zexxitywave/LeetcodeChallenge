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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        
        return buildSubTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inOrderMap);
    }
    
    private TreeNode buildSubTree(
        int[] preorder, int preStart, int preEnd,
        int[] inorder, int inStart, int inEnd,
        Map<Integer, Integer> inOrderMap) {
        
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndexInOrder = inOrderMap.get(rootVal);
        int leftSubtreeSize = rootIndexInOrder - inStart;
        root.left = buildSubTree(
            preorder, preStart + 1, preStart + leftSubtreeSize,
            inorder, inStart, rootIndexInOrder - 1,
            inOrderMap
        );
        
        root.right = buildSubTree(
            preorder, preStart + leftSubtreeSize + 1, preEnd,
            inorder, rootIndexInOrder + 1, inEnd,
            inOrderMap
        );
        
        return root;
    }
}
