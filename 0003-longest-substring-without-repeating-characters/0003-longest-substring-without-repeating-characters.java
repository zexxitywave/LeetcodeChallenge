class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;

        int i = 0;
        int j = 0;
        Set<Character> present = new HashSet<>();
        int longLength = Integer.MIN_VALUE;

        while(j < s.length()){
            if(!present.contains(s.charAt(j))){
                present.add(s.charAt(j));
                longLength = Math.max(j-i+1, longLength);
                j++;
            }else{
                present.remove(s.charAt(i));
                i++;
            }
        }
        return longLength;
    }
}