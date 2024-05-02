class Solution1 {
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

class Solution {
    public int findMaxK(int[] nums){
        Arrays.sort(nums);
        int k = 0;
        int ans = -1;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] > 0){
                k = i;
                break;
            }
        }
        
        for(int i = k; i<nums.length; i++){
            int no = nums[i];
            for(int j = k - 1; j>=0; j--){
                if(nums[j] * -1 == no ){
                    ans = Math.max(no , ans);
                }
            }
        }
        return ans;
    }
}