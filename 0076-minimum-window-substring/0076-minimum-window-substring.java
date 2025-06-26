class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return "";

        HashMap<Character, Integer> tChar = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(tChar.containsKey(c)){
                tChar.put(c, tChar.get(c)+ 1);
            }else{
                tChar.put(c, 1);
            }
        }

        HashMap<Character, Integer> window = new HashMap<>();
        int have = 0, need = tChar.size();
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;

        while( right < s.length()){
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c,0) + 1);
            if(tChar.containsKey(c) && window.get(c).intValue() == tChar.get(c).intValue()){
                have++;
            }

            while(have == need){
                if((right - left + 1)< minLength){
                    minLength = right - left + 1;
                    minLeft = left;
                }

                char lChar = s.charAt(left);
                window.put(lChar, window.get(lChar) - 1);
                if(tChar.containsKey(lChar) && window.get(lChar) < tChar.get(lChar)){
                    have--;
                }
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "": s.substring(minLeft, minLeft + minLength);
    }
}