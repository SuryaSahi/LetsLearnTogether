class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //Getting TLE on my PriorityQueue approach time - O(N*K) & space O(k)
        //Passed on cases using same approach O(nlogk) space O(k). I did'nt search for the element to be removed in second approach i used pq property
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->{
            return nums[b] - nums[a];
        });
        int[] result = new int[n-k+1];
        int index = 0;
        for(int i = 0; i<n; i++){
            while(pq.size()>0 && pq.peek() <= i - k){
                pq.remove();
            }
            pq.add(i);
            if(i>= k-1){
                result[index++] = nums[pq.peek()];
             }
        }
        return result;
    }
}
