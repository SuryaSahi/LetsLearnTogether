class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length <= 1)return true;
        int steps_left = nums[0];
        int position = 0;
        while(steps_left > 0){
            if(position == nums.length - 1)return true;
            steps_left = Math.max(steps_left - 1 , nums[position]);
            position++;
        }
        return false;
    }
}