class Solution {
    public String intToRoman(int num) {
        // Define mappings of integer values to Roman numeral symbols
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder roman = new StringBuilder();
        
        // Loop through each value
        for (int i = 0; i < values.length && num > 0; i++) {
            // Determine the number of times the current value fits into num
            while (num >= values[i]) {
                // Append the corresponding symbol and reduce num
                roman.append(symbols[i]);
                num -= values[i];
            }
        }
        
        return roman.toString();
    }
}
