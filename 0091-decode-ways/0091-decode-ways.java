class Solution {
    public int numDecodings(String s) {
        int[] res = new int[s.length() + 1];
        Arrays.fill(res , -1);
        return helper(s , 0 , res);
    }
    
    public int helper(String s , int index , int[] res){
        if(index == s.length())return 1;
        if(res[index] != -1) return res[index];
        if(s.charAt(index) == '0')return 0;
        
        int ways = helper(s , index + 1 , res);
        
        if(index + 1 < s.length() && Integer.parseInt(s.substring(index , index + 2 )) <= 26)
            ways += helper(s , index + 2 , res);
        
        res[index] = ways;
        
        return ways;
    }
}