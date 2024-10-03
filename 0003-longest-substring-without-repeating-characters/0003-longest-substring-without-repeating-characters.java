class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, count = 0, maxLength = 0;

        HashMap<Character, Integer> num = new HashMap<>();
        for(int end=0; end< s.length(); end++){
            char currentChar = s.charAt(end);
            if(num.containsKey(currentChar)){
                start = Math.max(start, num.get(currentChar)+1);
            }
            num.put(currentChar, end);

            count= end- start +1;

            maxLength = Math.max(count, maxLength);
        }return maxLength;
    }
}