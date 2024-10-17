class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        /*Conditions for Binary Tree
        1. Only one root
        2. No node should have more than one parent
        3. No disjoint nodes
        */
        
        //Key method used is BFS
        //2. Using HashMap to keep pair of children to parent  & 3. No disjoint nodes check using Adjancey List
        HashMap<Integer , Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<n; i++){
            int node = i;
            int left_child = leftChild[i];
            int right_child = rightChild[i];
            
            if(left_child != -1){
                adj.get(node).add(left_child);
                if(map.containsKey(left_child))return false;
                else map.put(left_child , i);
            }
            if(right_child != -1){
                adj.get(node).add(right_child);
                if(map.containsKey(right_child))return false;
                else map.put(right_child , i);
            }
        }
        //1. Checking if there is more than one root
        int root = -1;
        for(int i = 0; i<n; i++){
            if(!map.containsKey(i)){
                if(root != -1)return false;
                root = i;
            }
        }
        //1. checking if there is no root
        if(root == -1)return false;
        
        //using BFS to check if all nodes are visited
        
        int count = 1;
        Queue<Integer> que = new LinkedList<>();
        boolean[] vis = new boolean[n];
        que.add(root);
        vis[root] = true;
        
        while(!que.isEmpty()){
            int node = que.poll();
            for(int child : adj.get(node)){
                if(vis[child] == true)return false;
                if(!vis[child]){
                    count++;
                    que.add(child);
                    vis[child] = true;
                }
            }
        }
        return count == n;
    }
}