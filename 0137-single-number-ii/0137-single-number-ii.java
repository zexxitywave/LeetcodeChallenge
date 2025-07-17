class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twoes = 0;

        for(int num: nums){
            ones = (num ^ ones) & (~twoes);
            twoes = (num ^ twoes) & (~ones);
        }

        return ones;
    }
}