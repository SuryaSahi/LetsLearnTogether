class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(1,k,n,ans,new ArrayList<>(),0);
        return ans;
    }
    
    public void helper(int i , int k , int n , List<List<Integer>> ans , List<Integer> res, int sum){
        if(res.size() == k){
            if(sum == n){
                ans.add(new ArrayList<>(res));
                return;
            }
            else return;
        }
        if(res.size() > k)return;
        
        for(int index = i; index<=9; index++){
            if(sum + index <= n){
                res.add(index);
                helper(index+1,k,n,ans,res,sum + index);
                res.remove(res.size() - 1);
            }
            else{
                break;
            }
        }
    }
}