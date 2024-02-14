class Solution {
    public void helper(String res , int open , int close , List<String> ans , int n){
        if(open == n && close == n){
            ans.add(res);
            return;
        }
        if(open < n){
            //res = res +  "(";
            helper(res + "(",open+1,close,ans,n);
        }
        if(close < open){
            //res = res + ")";
            helper(res + ")",open,close+1,ans,n);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper("",0,0,ans,n);
        return ans;
    }
}