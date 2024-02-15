class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        //int n = ans.length() - 1;
        helper(0 , nums,new ArrayList() ,ans );
        return ans;
    }
    public void helper(int index , int[] nums , List<Integer> res ,List<List<Integer>> ans){
        ans.add(new ArrayList<>(res));
        for(int i = index; i<nums.length; i++){
            res.add(nums[i]);
            helper(i+1,nums,res,ans);
            res.remove(res.size() - 1);
        }
    }
}