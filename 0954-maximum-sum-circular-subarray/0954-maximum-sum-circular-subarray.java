class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int currMax = 0;
        int maxSum = Integer.MIN_VALUE;
        int currMin = 0;
        int minSum = Integer.MAX_VALUE;


        for(int num : nums){
            currMax = Math.max(currMax + num, num);
            maxSum = Math.max(currMax, maxSum);

            currMin = Math.min(currMin + num, num);
            minSum = Math.min(currMin, minSum);

            total += num;
        }
        return (maxSum > 0)? Math.max(total - minSum, maxSum): maxSum;
    }
}