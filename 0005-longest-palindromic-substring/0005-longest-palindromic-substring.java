class Solution {

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int n = s.length();
        int maxLength = 0;
        String longestPalindrome = "";

        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
               
                if (isPalindrome(s, start, end)) {
                  
                    int currentLength = end - start + 1;
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                        longestPalindrome = s.substring(start, end + 1);
                    }
                }
            }
        }

        return longestPalindrome;
    }
}
