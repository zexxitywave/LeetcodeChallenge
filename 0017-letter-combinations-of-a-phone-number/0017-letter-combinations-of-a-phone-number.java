class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits == null || digits.length() == 0){
            return result;
        }

        HashMap<Character, String> digitToChar = new HashMap<>();
        digitToChar.put('2', "abc");
        digitToChar.put('3', "def");
        digitToChar.put('4', "ghi");
        digitToChar.put('5', "jkl");
        digitToChar.put('6', "mno");
        digitToChar.put('7', "pqrs");
        digitToChar.put('8', "tuv");
        digitToChar.put('9', "wxyz");

        backtrack(digits, 0, new StringBuilder(), digitToChar, result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current,
                           Map<Character, String> digitToChar, List<String> result) {
        // Base case: if we've reached the end of digits
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get current digit and corresponding letters
        char digit = digits.charAt(index);
        String letters = digitToChar.get(digit);

        // Loop through the possible letters and recurse
        for (char letter : letters.toCharArray()) {
            current.append(letter);  // choose
            backtrack(digits, index + 1, current, digitToChar, result);  // explore
            current.deleteCharAt(current.length() - 1);  // un-choose (backtrack)
        }
    }
}