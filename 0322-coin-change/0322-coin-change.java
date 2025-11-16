class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] minCoinDp = new int[amount + 1];

        if(amount < 1) return 0;

        for(int i = 1; i <= amount; i++){
            minCoinDp[i] = Integer.MAX_VALUE;

            for(int coin : coins){
                if(coin <= i && minCoinDp[i - coin] != Integer.MAX_VALUE){
                    minCoinDp[i] = Math.min(minCoinDp[i], 1 + minCoinDp[i - coin]);
                }
            }
        }
        if(minCoinDp[amount] == Integer.MAX_VALUE) return -1;

        return minCoinDp[amount];
    }
}