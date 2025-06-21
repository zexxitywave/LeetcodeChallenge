class Solution {
    public int fib(int n) {
        int []dp = new int[n+1];
        return fibHelper(n, dp);
    }
    private int fibHelper(int n, int[] dp){
        if(n <= 1){
            return n;
        }
        if(dp[n]!= 0) return dp[n];

        dp[n]= fibHelper(n-1, dp) + fibHelper(n-2, dp);
        return dp[n];
    }
}