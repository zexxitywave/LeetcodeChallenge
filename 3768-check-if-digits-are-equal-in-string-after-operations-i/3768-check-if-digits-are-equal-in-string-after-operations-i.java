class Solution {
    public boolean hasSameDigits(String s) {
        int i = 0;
        String res = "";

        while(s.length() > 2 && i < s.length() - 1){
            res += (char)((((s.charAt(i) - '0') + (s.charAt(i+1) - '0')) % 10) + '0');
            i++;
            if( i == s.length() - 1){
                s = res;
                i = 0;
                res = "";
            }
        }
        return s.charAt(0) == s.charAt(1) && s.length() == 2;
    }
}