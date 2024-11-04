class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        
        while (!word.isEmpty()) {
            char c = word.charAt(0); // Current character
            int count = 0;
            
            // Count up to 9 consecutive occurrences of character `c`
            while (count < word.length() && count < 9 && word.charAt(count) == c) {
                count++;
            }
            
            // Append the count and character to the compressed result
            comp.append(count).append(c);
            
            // Remove the prefix of `count` characters from the word
            word = word.substring(count);
        }
        
        return comp.toString();
    }
}
