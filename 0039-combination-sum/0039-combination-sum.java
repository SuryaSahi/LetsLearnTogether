class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subsum = new ArrayList<>();
        helper(0,candidates,target,ans,subsum ,0);
        return ans;
    }
    public void helper(int i ,int[] cnd , int trg ,List<List<Integer>> ans , List<Integer> subsum , int sum){
        if(i == cnd.length)return;
    
        if(sum + cnd[i] <= trg){
            subsum.add(cnd[i]);
            sum += cnd[i];
            if(sum == trg){
                ans.add(new ArrayList<>(subsum));
            }
            helper(i, cnd , trg, ans , subsum , sum);
        //backtrack
            subsum.remove(subsum.size() - 1);
            sum -= cnd[i];
        }
        
        helper(i+1,cnd,trg,ans,subsum,sum);
    }
}