public class Solution {
    public int myAtoi(String s) {
        // Step 1: Trim leading whitespaces
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }

        // Step 2: Determine the sign
        int sign = 1;
        int index = 0;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            sign = (s.charAt(0) == '-') ? -1 : 1;
            index++;
        }

        // Step 3: Convert digits to an integer
        int result = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (!Character.isDigit(c)) {
                break; // Stop at the first non-digit character
            }

            int digit = c - '0';

            // Step 4: Handle overflow and underflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }
}
