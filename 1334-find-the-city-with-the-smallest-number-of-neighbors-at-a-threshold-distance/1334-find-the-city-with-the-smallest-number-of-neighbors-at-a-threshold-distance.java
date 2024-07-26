class Solution1 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //using floyd-warshal alogrithm to find shortest distance to every node
        
        int [][]dist = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++)dist[i][j] = Integer.MAX_VALUE;
        }
        
        //since the edges is bidirectional
        for(int i = 0; i<n; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            int wt = edges[i][2];
            dist[x][y] = wt;
            dist[y][x] = wt;
        }
        for(int i = 0; i<n; i++)dist[i][i] = 0;
        for(int k =0; k<n; k++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)continue;
                    
                    //updating distance of the shortest path
                    dist[i][j] = Math.min(dist[i][j] , dist[i][k] + dist[k][j]);
                }
            }
        }
        
        int citycnt = n;
        int City = -1;
        
        for(int i = 0; i<n; i++){
            int cnt = 0;
            for(int j = 0; j<n; j++){
                if(dist[i][j] <= distanceThreshold)cnt++;
            }
            
            if(cnt <= citycnt){
                citycnt = cnt;
                City = i;
            }
        }
        return City;
    }
}

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Using Floyd-Warshall algorithm to find shortest distances between all pairs of nodes
        int [][] dist = new int[n][n];
        
        // Initialize the distance matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        // Populate the distance matrix with edge weights
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            int wt = edges[i][2];
            dist[x][y] = Math.min(dist[x][y], wt);
            dist[y][x] = Math.min(dist[y][x], wt);
        }
        
        // Apply Floyd-Warshall to compute shortest paths between all pairs of nodes
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        
        // Determine the city with the smallest number of reachable cities within the threshold
        int cityCnt = n;
        int City = -1;
        
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) cnt++;
            }
            
            if (cnt <= cityCnt) {
                cityCnt = cnt;
                City = i;
            }
        }
        return City;
    }
}
