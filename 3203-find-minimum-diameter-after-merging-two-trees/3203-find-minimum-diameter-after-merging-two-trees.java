class Solution {
    private class Tree {
        Map<Integer, List<Integer>> graph;
        Map<Integer, Integer> diameterFromLength0;
        Tree(int[][] edges) {
            graph = new HashMap<>();
            for(int[] edge: edges) {
                graph.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
                graph.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
            }
            diameterFromLength0 = new HashMap<>();
        }
        private int calcDiameter(int root, Set<Integer> visited) {
            visited.add(root);
            int childrenMaxLength = 0;
            int children2ndMaxLength = 0;
            int maxDiameterChild = 0;
            int hasChild = 0;
            for(int child: graph.get(root)) {
                if(!visited.contains(child)) {
                    hasChild++;
                    maxDiameterChild = Math.max(maxDiameterChild, calcDiameter(child, visited));
                    if(diameterFromLength0.get(child) >= childrenMaxLength) {
                        children2ndMaxLength = childrenMaxLength;
                        childrenMaxLength = diameterFromLength0.get(child);
                    } else if(diameterFromLength0.get(child) > children2ndMaxLength) {
                        children2ndMaxLength = diameterFromLength0.get(child);
                    }
                }
            }
            if(hasChild > 0) {
                diameterFromLength0.put(root, childrenMaxLength + 1);
                return Math.max(maxDiameterChild, 
                    childrenMaxLength + children2ndMaxLength + (hasChild > 1 ? 2: 1));
            }
            diameterFromLength0.put(root, 0);
            return 0;
        }
        int getDiameter() {
            if(graph.size() < 1) return 0;
            return calcDiameter(0, new TreeSet<>());
        }
    }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        // WHY IS THIS PROBLEM HARD?
        int diameter1 = new Tree(edges1).getDiameter();
        int diameter2 = new Tree(edges2).getDiameter();
        int halfD1 = diameter1/2;
        int halfD2 = diameter2/2;
        int biggerHalf1 = diameter1 - halfD1;
        int biggerHalf2 = diameter2 - halfD2;
        return Math.max(Math.max(diameter1, diameter2), biggerHalf1 + biggerHalf2 + 1);
    }
}