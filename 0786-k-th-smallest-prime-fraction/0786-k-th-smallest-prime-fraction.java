import java.util.*;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int[] ans = new int[2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> (double) a[0] / a[1]));
        
        for (int i = 0; i < arr.length - 1; i++) {
            pq.offer(new int[]{arr[i], arr[arr.length - 1], i, arr.length - 1});
        }
        
        while (k > 0) {
            int[] curr = pq.poll();
            ans[0] = curr[0];
            ans[1] = curr[1];
            if (curr[3] > 0) {
                pq.offer(new int[]{curr[0], arr[curr[3] - 1], curr[2], curr[3] - 1});
            }
            k--;
        }
        
        return ans;
    }
}



