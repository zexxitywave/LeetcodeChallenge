class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][k];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve (0,0,0,grid,k,dp);
    }

    static final int MOD = 1_000_000_007;
    public int solve(int i, int j, int sum, int[][] grid, int k, int[][][] dp){
        int m = grid.length;
        int n = grid[0].length;

        if(i == m-1 && j == n-1){
            sum = (sum + grid[i][j])% k;
            return sum == 0 ? 1 : 0; 
        }

        if(i == m || j == n){
            return 0;
        }

        if(dp[i][j][sum] != -1){
            return dp[i][j][sum];
        }
        
        int newSum = (sum + grid[i][j]) % k;

        long right = solve(i, j+1, newSum, grid, k, dp);
        long down = solve(i+1, j, newSum, grid, k, dp);

        return dp[i][j][sum] = (int)((right + down) % MOD);
    }
}