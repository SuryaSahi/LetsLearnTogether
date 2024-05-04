class Solution {
    public boolean canFinish(int n, int[][] pre) {
    //noice question we will use topological sort to detect a cycle cause that will evade the premises 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i<pre.length; i++){
            adj.get(pre[i][0]).add(pre[i][1]);
        }
        
        int[] vis = new int[n];
        int[] pathvis = new int[n];
        for(int i = 0; i<n; i++){
            if(vis[i] == 0){
                if(cyclecheck(adj , vis , pathvis , i))return false;
            }
        }
        return true;
    }
    
    public boolean cyclecheck(ArrayList<ArrayList<Integer>> adj , int[] vis , int[] pathvis , int node)    {
     vis[node] = 1;
     pathvis[node] = 1;
        
        for(int num : adj.get(node)){
            if(vis[num] == 0){
                if(cyclecheck(adj , vis , pathvis , num) == true)return true;
            }
            else if(pathvis[num] == 1)return true;
        }
        pathvis[node] = 0;
        return false;
    }
}