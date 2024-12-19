class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        int max = 0;
        for(int i = 0; i<n; i++){
            max = Math.max(arr[i] , max);
            if(max == i)cnt++;
        }
        return cnt;
    }
}