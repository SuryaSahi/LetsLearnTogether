class Solution {
    public static int findmax(int[] v){
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<v.length; i++){
            ans = Math.max(v[i] , ans);
        }
        return ans;
    }
     public static int CalcuHrs(int[] v , int h ){
        int totalH = 0;
        for(int i = 0; i< v.length; i++){
             totalH += Math.ceil((double)(v[i]) / (double)(h));
        }
        return totalH;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1 , high = findmax(piles);
        // int ans = 0;
        while(low <= high){
            int mid = (low + high)/2;
            int check = CalcuHrs(piles , mid);
            if(check <= h)high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}