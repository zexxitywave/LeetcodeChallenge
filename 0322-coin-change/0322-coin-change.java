class Solution {
    public int coinChange(int[] coins, int amount) {
      if(amount < 1) return 0;

      int[] coinsDP = new int[amount + 1];

      for(int i = 1; i <= amount; i++){
        coinsDP[i] = Integer.MAX_VALUE;
        for(int coin : coins){
            if(coin <= i && coinsDP[i - coin] != Integer.MAX_VALUE){
                coinsDP[i] = Math.min(coinsDP[i], 1 + coinsDP[i - coin]);
            }
        }
      }
      if(coinsDP[amount] == Integer.MAX_VALUE) return -1;
      return coinsDP[amount];
    }
}