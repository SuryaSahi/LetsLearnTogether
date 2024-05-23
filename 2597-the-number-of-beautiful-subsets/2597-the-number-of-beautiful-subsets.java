class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int[] count = new int[1001];
        return solver(nums , 0 , k , count) - 1;
        
    }
    
    private int solver(int[] num , int index , int k ,int[] count ){
        if(index >= num.length)return 1;
        
        int ans = 0;
        if(num[index] - k < 0 || count[num[index] - k] == 0){
            count[num[index]]++;
            ans += solver(num , index + 1 , k , count);
            count[num[index]]--;
        }
        
        ans += solver(num , index + 1 , k , count);
        return ans;
    }
}