class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        HashMap<Character, Integer> tChar = new HashMap<>();
        for (int k = 0; k < t.length(); k++) {
            char c = t.charAt(k);
            tChar.put(c, tChar.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int start = 0; 
        int required = tChar.size();
        int formed = 0;
        int minLen = Integer.MAX_VALUE;

        HashMap<Character, Integer> windowCount = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            if (tChar.containsKey(c) && windowCount.get(c).intValue() == tChar.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);
                if (tChar.containsKey(leftChar) && windowCount.get(leftChar) < tChar.get(leftChar)) {
                    formed--;
                }
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
