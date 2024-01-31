class Solution {
    public void sortColors(int[] nums) {
        //using Dutch National flag Algorithm
        int low = 0 , mid = 0,  high = nums.length - 1;
        while(mid <= high){
            if(nums[mid] == 0){
                //swapping mid and low
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            //swapping high and mid
            else{
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
}