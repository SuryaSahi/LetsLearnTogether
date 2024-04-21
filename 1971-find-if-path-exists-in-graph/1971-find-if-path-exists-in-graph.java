class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //using BFS 
        Map<Integer , ArrayList<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        
        queue.add(source);
        visited.add(source);
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(node == destination)return true;
            
            List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());
            
            for(int neigh : neighbors){
                if(!visited.contains(neigh)){
                    visited.add(neigh);
                    queue.add(neigh);
                }
            }
        }
        return false;
    }
}