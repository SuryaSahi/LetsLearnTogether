class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(0,nums,ans,new ArrayList<>());
        return ans;
    }
    
    public void helper(int index , int[] nums ,List<List<Integer>> ans, List<Integer> set ){
        ans.add(new ArrayList<>(set));
        for(int i = index; i<nums.length; i++){
            if(i != index && nums[i] == nums[i-1])continue;
            set.add(nums[i]);
            helper(i+1,nums,ans,set);
            set.remove(set.size() - 1);
        }
    }
}