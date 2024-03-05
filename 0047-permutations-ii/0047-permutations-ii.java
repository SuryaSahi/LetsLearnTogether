class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans =  new ArrayList<>();
        helper(0 , nums ,  new ArrayList<>() ,ans , new boolean[nums.length]);
        return ans;
    }
    public void helper(int index , int[] nums , List<Integer> res , List<List<Integer>> ans , boolean[] used){
        if(index == nums.length){
            ans.add(new ArrayList<>(res));
            return;
        }
        
        for(int i = 0; i<nums.length; i++){
            if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i - 1])) continue;
               
            used[i] = true;
            res.add(nums[i]);
            helper(index+1, nums,res,ans,used);
            res.remove(res.size() - 1);
            used[i] = false;   
        }
    }
}