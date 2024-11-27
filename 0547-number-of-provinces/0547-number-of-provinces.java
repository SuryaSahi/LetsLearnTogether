class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j); 
                    adj.get(j).add(i); 
                }
            }
        }
        int vis[] = new int[n];
        int cnt = 0;
        for(int i = 0 ; i<n; i++){
            if(vis[i] == 0){
                cnt++;
                dfs(vis,adj,i);
            }
        }
        return cnt;
    }
    
    public void dfs(int vis[] , ArrayList<ArrayList<Integer>> adj , int index){
        vis[index] = 1;
        for(Integer t : adj.get(index)){
            if(vis[t] == 0)dfs(vis,adj,t);
        }
    }
}