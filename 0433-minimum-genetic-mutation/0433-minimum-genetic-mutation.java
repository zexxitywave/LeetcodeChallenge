class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        // Convert bank array to set for O(1) lookup
        Set<String> bankSet = new HashSet<>();
        for (String gene : bank) {
            bankSet.add(gene);
        }
        
        // If end gene not in bank, impossible to reach
        if (!bankSet.contains(endGene)) {
            return -1;
        }
        
        // BFS queue for genes
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        
        // Track visited genes
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        
        // Valid gene characters
        char[] geneChars = {'A', 'C', 'G', 'T'};
        
        int level = 0; // Number of mutations
        
        // BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Process all genes at current mutation level
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                
                // Check if we reached the target
                if (current.equals(endGene)) {
                    return level;
                }
                
                // Try mutating each position
                char[] currentArray = current.toCharArray();
                for (int pos = 0; pos < 8; pos++) {
                    char original = currentArray[pos];
                    
                    // Try all possible gene characters
                    for (char c : geneChars) {
                        if (c == original) continue; // Skip same character
                        
                        currentArray[pos] = c;
                        String mutated = String.valueOf(currentArray);
                        
                        // If valid mutation and not visited yet
                        if (bankSet.contains(mutated) && !visited.contains(mutated)) {
                            queue.add(mutated);
                            visited.add(mutated);
                        }
                    }
                    
                    // Revert change for next position
                    currentArray[pos] = original;
                }
            }
            
            level++; // Move to next mutation step
        }
        
        // No valid mutation path found
        return -1;
    }
}