class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.first == b.first)return a.index - b.index;
            return a.first - b.first;
        });
        
        for(int i = 0; i<nums.length; i++){
            pq.add(new Pair(nums[i],i));
        }
        
        while(k-- > 0){
            Pair temp = pq.poll();
            int num = temp.first;
            int ind = temp.index;
            num *= multiplier;
            nums[ind] = num;
            pq.add(new Pair(num , ind));
        }
        
        return nums;
    }
}

class Pair {
    int first;
    int index;
    Pair(int first , int index){
        this.first = first;
        this.index = index;
    }
}