public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build adjacency list
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }
        
        int[] visited = new int[numCourses]; 
        // 0 = unvisited, 1 = visiting, 2 = visited
        
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean hasCycle(List<List<Integer>> graph, int[] visited, int course) {
        if (visited[course] == 1) return true;  // Found a cycle
        if (visited[course] == 2) return false; // Already checked, no cycle
        
        visited[course] = 1; // Mark as visiting
        
        for (int next : graph.get(course)) {
            if (hasCycle(graph, visited, next)) {
                return true;
            }
        }
        
        visited[course] = 2; // Mark as fully visited
        return false;
    }
}
