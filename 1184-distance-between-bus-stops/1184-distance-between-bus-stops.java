class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum1 = 0 , sum2 = 0;
        for(int i = 0; i<distance.length; i++){
            if(i >= start && i < destination || start > i && destination <= i)sum1 += distance[i];
            else sum2 += distance[i];
        }
        return Math.min(sum1 , sum2);
    }
}