class Solution {
    public void dfs(List<List<Integer>> rooms , boolean[] vis , int source){
        vis[source] = true;
        
        for( int node : rooms.get(source)){
            if(!vis[node])dfs(rooms , vis , node);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        
        boolean[] vis = new boolean[n];
        for(int i = 0; i<n; i++)vis[i] = false;
        
        dfs(rooms , vis , 0);
        
        for(int i = 0; i<n; i++){
            if(!vis[i])return false;
        }
        
        return true;
    }
}