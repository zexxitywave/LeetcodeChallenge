class Solution {
    public int minChanges(String s) {
        int changes = 0;
    
        // Iterate over the string in pairs
        for (int i = 0; i < s.length(); i += 2) {
            // Check each pair (s[i], s[i+1])
            if (s.charAt(i) != s.charAt(i + 1)) {
                // Increment changes if the pair is not uniform
                changes++;
            }
        }
    
    return changes;

    }
}