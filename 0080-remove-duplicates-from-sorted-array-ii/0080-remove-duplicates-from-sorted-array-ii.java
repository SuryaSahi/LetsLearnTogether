class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 2)return nums.length;
        
        int j = 1; // position of twin element
        for(int i = 2; i<n; i++){
            if(nums[i] != nums[j-1]){
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}