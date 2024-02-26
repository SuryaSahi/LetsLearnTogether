class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        helper(0,nums,ans, res);
        return ans;
    }
    
    public void helper(int index , int[] nums ,List<List<Integer>> ans , List<Integer> res){
        if(index == nums.length){
            ans.add(new ArrayList<>(res));
                return;
        }
        //ans.add(new ArrayList<>(res));
        //for(int i = index; i<nums.length; i++){
        res.add(nums[index]);
        helper(index + 1 , nums,ans , res);
        res.remove(res.size() - 1);
        helper(index + 1 , nums , ans , res);
        //}   
    }
}