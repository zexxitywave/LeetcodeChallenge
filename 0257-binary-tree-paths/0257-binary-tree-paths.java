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

        if(root != null){
            Paths(root, "", paths);
        }
        
        
    return paths;
    }

    public void Paths(TreeNode node, String path, List<String> paths ){

        path += node.val;

        if(node.left == null && node.right == null){
            paths.add(path);
        }

        if(node.left != null){
            Paths(node.left,path + "->", paths);  
        }

        if(node.right != null){
            Paths(node.right,path + "->", paths);
        }
    }
}
