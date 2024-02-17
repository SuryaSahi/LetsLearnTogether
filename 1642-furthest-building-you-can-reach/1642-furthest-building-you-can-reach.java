class Solution {
    public int furthestBuilding(int[] height, int bricks, int ladders) {
       PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> y-x);
       int i = 0;
       for(i=0; i<height.length - 1; i++){
           int diff = height[i+1] - height[i];
           if(diff <= 0)continue;
           
           bricks -= diff;
           pq.offer(diff);
           if(bricks < 0){
               bricks += pq.poll();
               ladders--;
           }
           if(ladders < 0)break;
       } 
        return i;
    }
}
