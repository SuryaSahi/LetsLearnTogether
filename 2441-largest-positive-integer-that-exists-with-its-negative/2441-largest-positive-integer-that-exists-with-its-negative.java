class Solution {
    public int findMaxK(int[] nums) {
        int no =  -1;
        for(int i = 0; i<nums.length; i++){
            int j = nums[i];
            for(int k = 0; k<nums.length; k++){
                if(nums[k] * -1 == j){
                    no = Math.max(no , j);
                }
            }
        }
        return no;
    }
}