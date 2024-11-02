class Solution {
    public boolean isCircularSentence(String sentence) {
        // Split the sentence into words
        String[] words = sentence.split(" ");
        
        // Check if the first character of the first word matches the last character of the last word
        if (words[0].charAt(0) != words[words.length - 1].charAt(words[words.length - 1].length() - 1)) {
            return false;
        }
        
        // Check if each word starts with the last character of the previous word
        for (int i = 1; i < words.length; i++) {
            // The current word should start with the last character of the previous word
            if (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
                return false;
            }
        }
        
        // If all checks passed, the sentence is circular
        return true;
    }
}
