class Solution {
    int ans = 0;
    public int subsetXORSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        helper(nums , list , 0);
        return ans;
    }
    public void helper(int[] nums , List<Integer> list , int index){
        if(index == nums.length){
            int result = 0;
            for(int i : list){
                result ^= i;
            }
            ans += result;
            return;
        }
        
        list.add(nums[index]);
        helper(nums , list , index + 1);
        list.remove(list.size() - 1);
        helper(nums , list , index + 1);
    }
}