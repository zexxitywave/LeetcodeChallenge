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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();

        if(root == null){
            return paths;
        }
        
        if(root.left == null && root.right == null){
            paths.add(String.valueOf(root.val));
            return paths;
        }

        if(root.left != null){
            for(String path: binaryTreePaths(root.left)){
                paths.add(root.val + "->" + path);
            }
        }

        if(root.right != null){
            for(String path: binaryTreePaths(root.right)){
                paths.add(root.val + "->" + path);
            }
        }
    return paths;
    }

}