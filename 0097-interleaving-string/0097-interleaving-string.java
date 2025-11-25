class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();

        if(s3.length() != n + m) return false;

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int r = 0; r <= n; r++){
            for(int c = 0; c<= m; c++){
                if(r > 0 && dp[r-1][c] && s1.charAt(r-1) == s3.charAt(r-1+c)){
                    dp[r][c] = true;
                }else if(c>0 && dp[r][c-1] && s2.charAt(c-1) == s3.charAt(r+c-1)){
                    dp[r][c] = true;
                }
            }
        }
        return dp[n][m];
    }
}