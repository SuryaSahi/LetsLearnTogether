class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> ans= new HashSet<>();
        int maxsum = 0;
        int i = 0 , j = 0;
        int sum = 0;
        while(i < nums.length && j < nums.length)
        {
            if(!ans.contains(nums[j])){
                sum += nums[j];
                maxsum = Math.max(sum , maxsum);
                ans.add(nums[j]);
                j++;
            }
            else{
                sum -= nums[i];
                ans.remove(nums[i]);
                i++;
            }
        }
        return maxsum;
    }
}