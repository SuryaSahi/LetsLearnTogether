class Solution {
    class Pair{
        int quality;
        double ratio;
        Pair(int quality , int wage){
            this.quality = quality;
            this.ratio = (wage/(double)quality);
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<Pair> ratios = new ArrayList<>();
        for(int i = 0; i<quality.length; i++){
            ratios.add(new Pair(quality[i], wage[i]));
        }
        
        Collections.sort(ratios , (a,b)->Double.compare(a.ratio , b.ratio));
        double ans = Integer.MAX_VALUE , qsum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(Pair p : ratios){
            qsum += p.quality;
            pq.add((double)p.quality);
            if(pq.size() > k)qsum -= pq.remove();
            if(pq.size() == k)ans = Math.min(ans , p.ratio * qsum);
        }
        return ans;
    }
}