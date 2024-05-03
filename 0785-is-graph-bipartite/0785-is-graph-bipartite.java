class Solution {
    public boolean isBipartite(int[][] graph) {
        int colors[] = new int[graph.length];
        for(int i = 0; i<graph.length; i++){
            if(colors[i] == 0 && !dfs(i, graph, colors, true)){
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int s, int[][] graph, int colors[], boolean col){
        if(col) colors[s] = 1;
        else colors[s] = 2;
        for(int v : graph[s])
            if(colors[v] == (col ? 1 : 2) || colors[v] == 0 && !dfs(v, graph, colors, !col)) return false;
        return true;
    }
}