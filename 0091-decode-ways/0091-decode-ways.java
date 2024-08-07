class Solution {
    public int numDecodings(String s) {
        //solution done in top down memoization
        //do approach in bottom up 1D dp 
        int[] dp = new int[s.length() + 1];
        if(s.length() == 0)return 0;
        
        dp[s.length()] = 1;
        
        for(int i = s.length() - 1; i>= 0; i--){
            if(s.charAt(i) == '0')dp[i] = 0;
            
            else {
                dp[i] += dp[i + 1];
            
            if(i + 1 < s.length() && Integer.parseInt(s.substring(i , i+2)) <= 26)
                dp[i] += dp[i+2];
            }
        }
        return dp[0];
    }
}