class Solution {
    int global_ind = 0;
    public int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        for(int i = 0; i<nums.length; i++){
            maxSum = Math.max(maxSum , helper(i,nums));
            i = global_ind;
        }
        return maxSum;
    }
    public int helper(int ind , int[] nums){
        if(ind > nums.length)return 0;
        int sum = nums[ind];
        while(ind + 1 < nums.length && nums[ind] < nums[ind + 1]){
                ind = ind + 1;
                sum += nums[ind];
        }
        global_ind = ind;
        return sum;
    }   
}