class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        //Brute Force is 2 loops
        //Optimized is HashMap
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
                ans[0] = i;
                ans[1] = map.get(target - nums[i]);
            }
            else map.put(nums[i] , i);
        }
        return ans;
    }
}