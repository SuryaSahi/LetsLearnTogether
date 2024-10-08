class Solution {
    static final int mod = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = solve(n,k,target , dp);
            return ans;
    }
    
    public int solve(int n , int k , int target , int[][] dp){
        if(target < 0)return 0;
        if((n == 0 && target > 0) || (n != 0 && target <= 0)) return 0;
        
        if(n == 0 && target == 0)return 1;
        if(dp[n][target] != -1)return dp[n][target];
        int ans = 0;
        for(int i = 1; i<=k; i++){
            ans = (ans + solve(n - 1, k, target - i , dp)) % mod;
        }
        return dp[n][target] = ans;
    }
}