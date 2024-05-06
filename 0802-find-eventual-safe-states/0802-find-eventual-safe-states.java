class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<graph.length; i++){
            adj.add(new ArrayList<>());
        }
        int v = graph.length;
        int[] indegree = new int[v];
        for(int i = 0; i<v; i++){
            for(int j : graph[i]){
                adj.get(j).add(i);
                indegree[i]++;
            }
        }
        List<Integer> safenode = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<v; i++){
            if(indegree[i] == 0)q.add(i);
        }
        
        while(!q.isEmpty()){
            int val = q.poll();
            safenode.add(val);
            
            for(int num : adj.get(val)){
                indegree[num]--;
                if(indegree[num] == 0)q.add(num);
            }
        }
        Collections.sort(safenode);
        return safenode;
    }
}