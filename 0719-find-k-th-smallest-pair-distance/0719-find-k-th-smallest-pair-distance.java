class Solution1 {
    public int smallestDistancePair(int[] nums, int k) {
        List<Integer> storage = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                int diff = Math.abs(nums[i] - nums[j]);
                storage.add(diff);
            }
        }
        Collections.sort(storage);
        //if( k == nums.length)return storage.get(k-1);
        return storage.get(k-1);
    }
}

class Solution {
    public int smallestDistancePair(int[] nums , int k){
        Arrays.sort(nums);
        int low = 0 , high = nums[nums.length - 1] ;
        while(low < high){
            int mid = low + (high - low ) / 2;
            if(CountPairs(nums , mid) < k)low = mid + 1;
            else high = mid;
        }
        return low;
    }
    
    public int CountPairs(int []nums , int maxdist){
        int count = 0, j = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (j < nums.length && nums[j] - nums[i] <= maxdist) ++j;
            count += j - i - 1;
        }
        return count;
    }
}