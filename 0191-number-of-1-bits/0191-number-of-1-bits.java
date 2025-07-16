class Solution {
    public int hammingWeight(int n) {
        String binStr = Integer.toBinaryString(n);
        int result = 0;
        int helper = 1;
        for(int i = 1; i <= 32; i++){
            if((n & helper)!= 0){
                result++;
            }
        helper = helper << 1;
        }
        return result;
    }
}