import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build the adjacency list
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];
            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(new int[]{v, price});
        }
        
        // Priority queue to store [cost, city, stops]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, src, 0}); // [cost, city, stops]
        
        // Distance array
        int[][] dist = new int[n][k + 2]; // to store min cost to reach each city with up to k stops
        
        // Initialize distances to infinity
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        dist[src][0] = 0;
        
        // Process the priority queue
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int u = curr[1];
            int stops = curr[2];
            
            // If the destination is reached
            if (u == dst) return cost;
            
            // If the number of stops exceeds k, skip this path
            if (stops > k) continue;
            
            // Traverse adjacent cities
            for (int[] edge : adj.getOrDefault(u, Collections.emptyList())) {
                int v = edge[0];
                int price = edge[1];
                
                // Check if this path provides a cheaper cost
                if (cost + price < dist[v][stops + 1]) {
                    dist[v][stops + 1] = cost + price;
                    pq.add(new int[]{dist[v][stops + 1], v, stops + 1});
                }
            }
        }
        
        // Find the minimum cost to reach the destination with up to k stops
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i <= k + 1; i++) {
            minCost = Math.min(minCost, dist[dst][i]);
        }
        
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}
