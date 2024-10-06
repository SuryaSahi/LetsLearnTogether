class Solution {
    public int rob(int[] arr) {
    int n = arr.length;
        if(n == 1)return arr[0];
        if(n == 2)return Math.max(arr[0] , arr[1]);
        
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        Arrays.fill(dp1 , -1);
        Arrays.fill(dp2 , -1);
        
        int sum1 = solve1(arr , 0 , n - 1 , dp1);
        int sum2 = solve1(arr , 1 , n , dp2);
        
        return Math.max(sum1 , sum2);
    }
    
    public static int solve1(int[] arr , int i , int n , int[] dp){
        if(i >= n)return 0;
        
        if(dp[i] != -1)return dp[i];
        
        int taken = solve1(arr , i + 2 , n , dp) + arr[i];
        int nottaken = solve1(arr , i + 1 , n , dp) + 0;
        
        return dp[i] = Math.max(taken , nottaken);
        
    }
}