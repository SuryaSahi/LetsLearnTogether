class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //by default its max heap priorityqueue
        for(int i = 0; i<nums.length; i++){
            pq.add(nums[i]);
        }
        //extracting kth element from PriorityQueue
        for(int i = 0; i<nums.length - k; i++){
            pq.poll();
        }
        return pq.peek();
    }
}