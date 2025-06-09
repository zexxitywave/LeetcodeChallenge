/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        
        if (k == 0) {
            result.add(target.val);
            return result;
        }
        
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap);
        
        bfsDistanceK(target, k, parentMap, result);
        
        return result;
    }
    
    private void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) return;
        
        parentMap.put(node, parent);
        
        buildParentMap(node.left, node, parentMap);
        buildParentMap(node.right, node, parentMap);
    }
    
    private void bfsDistanceK(TreeNode target, int k, Map<TreeNode, TreeNode> parentMap, List<Integer> result) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        
        queue.offer(target);
        visited.add(target);
        
        int currentDistance = 0;
        
        while (!queue.isEmpty() && currentDistance < k) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                
                if (currentNode.left != null && !visited.contains(currentNode.left)) {
                    queue.offer(currentNode.left);
                    visited.add(currentNode.left);
                }
                
                if (currentNode.right != null && !visited.contains(currentNode.right)) {
                    queue.offer(currentNode.right);
                    visited.add(currentNode.right);
                }
                
                TreeNode parent = parentMap.get(currentNode);
                if (parent != null && !visited.contains(parent)) {
                    queue.offer(parent);
                    visited.add(parent);
                }
            }
            
            currentDistance++;
        }
        
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
    }
    
    public List<Integer> distanceKDFS(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap);
        
        Set<TreeNode> visited = new HashSet<>();
        dfsDistanceK(target, k, parentMap, visited, result);
        
        return result;
    }
    
    private void dfsDistanceK(TreeNode node, int k, Map<TreeNode, TreeNode> parentMap, 
                             Set<TreeNode> visited, List<Integer> result) {
        if (node == null || visited.contains(node)) return;
        
        visited.add(node);
        
        if (k == 0) {
            result.add(node.val);
            return;
        }
        
        dfsDistanceK(node.left, k - 1, parentMap, visited, result);
        dfsDistanceK(node.right, k - 1, parentMap, visited, result);
        dfsDistanceK(parentMap.get(node), k - 1, parentMap, visited, result);
    }
}