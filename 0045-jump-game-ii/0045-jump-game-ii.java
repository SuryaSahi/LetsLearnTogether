class Solution {
    public int jump(int[] nums) {
        if(nums.length <= 1)return 0;
        int max = 0 , current = 0 , cnt = 0;
        for(int i = 0; i<nums.length-1; i++){
            max = Math.max(i + nums[i] , max);
            if(current == i){
                current = max;
                cnt++;
            }
        }
        return cnt;
    }
}