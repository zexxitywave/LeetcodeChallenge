class Solution {
    public String makeFancyString(String s) {
        char chars[]= s.toCharArray();
        StringBuilder fancyString = new StringBuilder();
        for(int i = 0; i< chars.length; i++){
            int length = fancyString.length();
            if(length>=2 && fancyString.charAt(length-1)== chars[i] && fancyString.charAt(length-2) == chars[i]){
                continue;
            }
            fancyString.append(chars[i]);
        }
        return fancyString.toString();
    }
}