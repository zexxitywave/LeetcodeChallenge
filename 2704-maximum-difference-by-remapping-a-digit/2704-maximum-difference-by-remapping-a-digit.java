class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);

        String maxStr = s;
        for(char c : s.toCharArray()){
            if(c != '9'){
                maxStr = s.replace(c, '9');
                break;
            }
        }

        String minStr = s;
        
        minStr = minStr.replace(minStr.charAt(0), '0');
        

        int maxNum = Integer.parseInt(maxStr);
        int minNum = Integer.parseInt(minStr);

        return maxNum - minNum;
    }
}