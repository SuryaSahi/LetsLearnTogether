class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for(int i = 0; i<n; i++){
            if(color[i] == 0 && !bfs(color , graph , i , true))return false;
        }
        return true;
    }
    
    public boolean bfs(int[] color , int[][] graph , int node , boolean red){
        if(red) color[node] = 1;
        else color[node] = 2;
        for(int num : graph[node]){
            if(color[num] == (red ? 1 : 2) || color[num] == 0 && !bfs(color , graph , num , !red))return false;
        }
        return true;
    }
}