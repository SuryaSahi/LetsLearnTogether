class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);  // Initialize dp array with -1
        dp[0] = 0;  // Base case: 0 coins to make amount 0
        
        int result = solve(coins, amount, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    public int solve(int[] coins, int amount, int[] dp) {
        if (amount < 0) return Integer.MAX_VALUE;
        if (dp[amount] != -1) return dp[amount];
        
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = solve(coins, amount - coin, dp);
            if (res != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, res + 1);  // Add 1 to include the current coin
            }
        }
        
        dp[amount] = minCoins;  // Memoize the result
        return dp[amount];
    }
}
