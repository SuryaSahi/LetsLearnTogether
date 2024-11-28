class Solution {
    public double[] calcEquation(List<List<String>> eq, double[] values, List<List<String>> queries) {
        // Creating a graph (adjacency list)
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < eq.size(); i++) {
            String u = eq.get(i).get(0);
            String v = eq.get(i).get(1);

            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);

            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1 / values[i]);
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            // HashSet to track visited nodes
            ans[i] = dfs(graph, queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
        }

        return ans; 
    }

    public double dfs(Map<String, Map<String, Double>> graph, String src, 
                      String dest, HashSet<String> visited) {
        // If source node doesn't exist in the graph
        if (!graph.containsKey(src)) return -1.0;

        // If there is a direct edge to the destination
        if (graph.get(src).containsKey(dest)) return graph.get(src).get(dest);

        visited.add(src);

        for (Map.Entry<String, Double> nbr : graph.get(src).entrySet()) {
            if (!visited.contains(nbr.getKey())) {
                double weight = dfs(graph, nbr.getKey(), dest, visited);

                if (weight != -1.0) {
                    return nbr.getValue() * weight;
                }
            }
        }

        return -1.0;
    }
}
