class Solution {
    public double[] calcEquation(List<List<String>> eq, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < eq.size(); i++) {
            String u = eq.get(i).get(0);
            String v = eq.get(i).get(1);

            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());

            graph.get(u).put(v, values[i]);
            graph.get(v).put(u, 1 / values[i]);
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                ans[i] = -1.0;
            } else if (src.equals(dest)) {
                ans[i] = 1.0;
            } else {
                ans[i] = bfs(graph, src, dest);
            }
        }

        return ans;
    }

    private double bfs(Map<String, Map<String, Double>> graph, String src, String dest) {
        Queue<Pair> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new Pair(src, 1.0));
        visited.add(src);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String node = current.node;
            double value = current.value;

            if (node.equals(dest)) {
                return value;
            }

            for (Map.Entry<String, Double> neighbor : graph.get(node).entrySet()) {
                String nextNode = neighbor.getKey();
                double edgeWeight = neighbor.getValue();

                if (!visited.contains(nextNode)) {
                    visited.add(nextNode);
                    queue.offer(new Pair(nextNode, value * edgeWeight));
                }
            }
        }

        return -1.0;
    }
}

class Pair {
    String node;
    double value;

    Pair(String node, double value) {
        this.node = node;
        this.value = value;
    }
}
