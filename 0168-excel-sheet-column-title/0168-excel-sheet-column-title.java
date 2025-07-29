class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        
        while (columnNumber > 0) {
            columnNumber--;  
            int remainder = columnNumber % 26;
            char currentChar = (char) ('A' + remainder);
            result.insert(0, currentChar); 
            columnNumber = columnNumber / 26;
        }
        
        return result.toString();
    }
}
