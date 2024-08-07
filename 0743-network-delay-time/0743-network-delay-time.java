import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Convert the list of edges into an adjacency list
        // This map will store each node and its adjacent nodes along with the travel time
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] time : times) {
            int u = time[0];  // Source node
            int v = time[1];  // Destination node
            int wt = time[2]; // Travel time
            // Add edge to adjacency list
            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(new int[]{v, wt});
        }
        
        // Step 2: Initialize the priority queue for Dijkstra's algorithm
        // The priority queue will store nodes with their current shortest distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // Start from the node k with distance 0
        pq.add(new int[]{0, k});
        
        // Step 3: Initialize the distance array
        // Use Integer.MAX_VALUE to represent initially unreachable nodes
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; // Distance to the starting node k is 0
        
        // Step 4: Process the nodes
        while (!pq.isEmpty()) {
            int[] curr = pq.poll(); // Get the node with the smallest distance
            int u = curr[1];       // Current node
            int currDist = curr[0]; // Distance to the current node
            
            if (currDist > dist[u]) continue; // Skip if this path is not the shortest
            
            // Update distances to neighboring nodes
            for (int[] edge : adj.getOrDefault(u, Collections.emptyList())) {
                int v = edge[0];    // Neighbor node
                int time = edge[1]; // Travel time to the neighbor
                
                // If a shorter path to v is found, update the distance and add to the priority queue
                if (dist[u] + time < dist[v]) {
                    dist[v] = dist[u] + time;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }
        
        // Step 5: Determine the maximum distance from the starting node
        int maxtime = 0;
        for (int i = 1; i <= n; i++) {
            maxtime = Math.max(maxtime, dist[i]);
        }
        
        // If any node is still unreachable, return -1
        if (maxtime == Integer.MAX_VALUE) return -1;
        return maxtime; // Return the maximum time for all nodes to receive the signal
    }
}
