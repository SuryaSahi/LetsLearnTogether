class Solution {
    static final int mod = 1000000007; // modulo 
    public int numRollsToTarget(int n, int k, int target) {
        // int[][] dp = new int[n + 1][target + 1];
        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }
        int ans = solveTab(n,k,target);
            return ans;
    }
    
    public int solveMemo(int n , int k , int target , int[][] dp){
        // BASE CASE
        if((n == 0 && target > 0) || (n != 0 && target <= 0) || target < 0) return 0;
        
        if(n == 0 && target == 0)return 1;
        if(dp[n][target] != -1)return dp[n][target]; //overlapping sub problem saved values
        int ans = 0;
        for(int i = 1; i<=k; i++){
            ans = (ans + solveMemo(n - 1, k, target - i , dp)) % mod;
        }
        //memoize the value
        return dp[n][target] = ans;
    }
    public int solveTab(int n, int k, int target){
        int[][] dp = new int[n+1][target + 1];
        
        dp[0][0] = 1;
        for(int i = 1; i<=n; i++){
            for(int tar = 1; tar<=target; tar++){
                // dp[i][tar] = 0;
                for(int key = 1; key<=k; key++){
                    if(tar - key >= 0){
                        dp[i][tar] = (dp[i][tar] + dp[i - 1][tar - key]) % mod;
                    }
                }
            }
        }
        return dp[n][target];
    }
}