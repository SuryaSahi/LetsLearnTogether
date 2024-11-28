class Solution {
    int count = 0;

    public void dfs(int child, int parent, ArrayList<ArrayList<Pair>> adj) {
        for (Pair p : adj.get(child)) {
            int neighbour = p.first;
            int direction_check = p.second;

            if (neighbour != parent) {
                if (direction_check == 1) {
                    count++;
                }
                dfs(neighbour, child, adj); // Recursive DFS call for the neighbor
            }
        }
    }

    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int[] connect : connections) {
            adj.get(connect[0]).add(new Pair(connect[1], 1)); // Real connection
            adj.get(connect[1]).add(new Pair(connect[0], 0)); // Fake connection
        }

        // Start DFS
        dfs(0, -1, adj);

        return count;
    }
}

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}