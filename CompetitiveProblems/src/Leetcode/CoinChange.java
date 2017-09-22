package Leetcode;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        //dp array @ coin vals gets sets to 1
        for(int i = 0; i < coins.length; i++) {
            if(coins[i] < dp.length) {
                dp[coins[i]] = 1;
            }
        }
        for(int i = 1; i < dp.length; i++) {
            int minCoin = 1234567;
            for(int j = 0; j < coins.length; j++) {
                if(i-coins[j] >= 0) {
                    minCoin = Math.min(minCoin, dp[i-coins[j]]+1);
                }
            }
            dp[i] = minCoin;
        }
        return dp[dp.length-1] == 1234567 ? -1 : dp[dp.length - 1];
    }
}
