class Solution {
    public int hammingWeight(int n) {
        String binStr = Integer.toBinaryString(n);
        int result = 0;
        for(int i = 0; i < binStr.length(); i++){
            if(binStr.charAt(i) == '1'){
                result++;
            }
        }
        return result;
    }
}