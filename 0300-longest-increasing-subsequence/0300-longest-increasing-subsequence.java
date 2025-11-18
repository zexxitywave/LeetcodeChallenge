class Solution {
    public int lengthOfLIS(int[] nums) {
        int incSeq[] = new int[nums.length];

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){

                if(nums[i] > nums[j]){
                    incSeq[i] = Math.max(incSeq[j] + 1, incSeq[i]);
                }
            }
        }

        int maxSeq = 0;
        for(int i = 1; i < incSeq.length; i++){
            if(incSeq[i] > incSeq[maxSeq]){
                maxSeq = i;
            }
        }

        return incSeq[maxSeq] + 1;
    }
}