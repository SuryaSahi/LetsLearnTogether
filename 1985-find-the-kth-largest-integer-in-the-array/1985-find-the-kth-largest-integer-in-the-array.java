class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        // Brute force (n * m log n) time complexity
        
        //Using priority queue
        //Sorting the String Array
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> {
        if(a.length() != b.length()){
            return Integer.compare(a.length() , b.length());
        }
        return a.compareTo(b);
        });    
        
        for(String num : nums){
            pq.add(num);
            if(pq.size() > k)pq.poll();
        }
        
        return pq.poll();
    }
}