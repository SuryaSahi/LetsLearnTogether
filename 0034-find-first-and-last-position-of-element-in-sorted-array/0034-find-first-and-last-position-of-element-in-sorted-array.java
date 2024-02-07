class Solution {
    public int[] searchRange(int[] nums, int target) {
        //finding first occurance
        int n = nums.length;
        int first = firstoccurance(nums , n , target );
        if(first == n || nums[first] != target)return new int[]{-1 , -1};
        int last = lastoccurance(nums , n , target);
        return new int[]{first , last - 1};
    }
    public int firstoccurance(int[] nums, int n, int target){
        int low = 0 , high = n - 1;
        int ans = n;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] >= target){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public int lastoccurance(int[] nums, int n, int target){
        int low = 0 , high = n -1 ;
        int ans = n;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] > target){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}