class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        //creating adjancey list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int[] count = {0};
        dfs(adj,values,k,count,-1,0);
        return count[0];
    }
    
    public int dfs(List<List<Integer>> adj , int[] values , int k , int[] count , int parent , int curr){
        long sum = values[curr];
        for(int nbh : adj.get(curr)){
            if(nbh != parent){
                sum += dfs(adj,values,k,count,curr,nbh);
            }
        }
        
        sum = sum % k;
        if(sum == 0)count[0]++;
        return (int)sum;
    }
}