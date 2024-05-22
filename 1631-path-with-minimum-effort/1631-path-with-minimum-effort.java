class Solution {
    public int minimumEffortPath(int[][] h) {
        
        int m = h.length;
        int n = h[0].length;
        int[][] dist = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                dist[i][j] = (int)1e9;
            }
        }
        
        dist[0][0] = 0;
        PriorityQueue<tuple> pq = new PriorityQueue<>((a,b)-> a.distance - b.distance);
        pq.add(new tuple(0,0,0));
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        while(!pq.isEmpty()){
            tuple it = pq.remove();
            int diff = it.distance;
            int row = it.first;
            int col = it.second;
            
            if(row == m - 1 && col == n - 1)return dist[row][col];
            
            for(int i = 0; i<4; i++){
                int nrow = row + dx[i];
                int ncol = col + dy[i];
                if(nrow < m && ncol < n && nrow >= 0 && ncol >= 0){
                    int effort = Math.max(Math.abs(h[nrow][ncol] - h[row][col]) , diff);
                    if(effort < dist[nrow][ncol]){
                        dist[nrow][ncol] = effort;
                        pq.add(new tuple(effort , nrow , ncol));
                    }
                }
            }
        }
               return dist[m-1][n-1];
    }
}

class tuple{
    int distance , first , second;
    public tuple(int distance , int first , int second){
        this.distance = distance;
        this.first = first;
        this.second = second;
    }
}