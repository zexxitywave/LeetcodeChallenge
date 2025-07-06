class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] seqDP = new int[nums.length];

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(seqDP[j]+1 > seqDP[i]){
                        seqDP[i] = seqDP[j] + 1;
                    }
                }
            }
        }

        int maxIndex = 0;
        for(int i = 0; i < seqDP.length; i++){
            if(seqDP[i] > seqDP[maxIndex]){
                maxIndex = i;
            }
        }
        return seqDP[maxIndex] + 1;
    }
}